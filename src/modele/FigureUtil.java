package modele;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class FigureUtil {

	private static final int MIN = 0;
	private static final int MAX = 100;
	private static Map<String, Figure> map = new HashMap<String, Figure>();

	private static Point getRandomPoint() {
		return new Point(ThreadLocalRandom.current().nextInt(MIN, MAX), ThreadLocalRandom.current().nextInt(MIN, MAX));
	}

	public static Rond getRandomRond() {
		Rond rond = new Rond(getRandomPoint(), ThreadLocalRandom.current().nextInt(1, 50), Couleur.getRandomCouleur());
		map.put(rond.getId(), rond);
		return rond;

		// return new Rond(getRandomPoint(), ThreadLocalRandom.current().nextInt(1,
		// 50));

	}

	public static Rectangle getRandomRectangle() {
		Rectangle rect = new Rectangle(getRandomPoint(), ThreadLocalRandom.current().nextInt(MIN, MAX),
				ThreadLocalRandom.current().nextInt(MIN, MAX), Couleur.getRandomCouleur());
		map.put(rect.getId(), rect);
		return rect;

		// return new Rectangle(getRandomPoint(), ThreadLocalRandom.current().nextInt(0,
		// 50),
		// ThreadLocalRandom.current().nextInt(0, 50));
	}

	public static Carre getRandomCarre() {
		Carre carre = new Carre(getRandomPoint(), ThreadLocalRandom.current().nextInt(MIN, MAX),
				Couleur.getRandomCouleur());
		map.put(carre.getId(), carre);
		return carre;

		// return new Carre(getRandomPoint(), ThreadLocalRandom.current().nextInt(0,
		// 50));
	}

	public static Segment getRandomSegment() {
		Segment seg = new Segment(getRandomPoint(), ThreadLocalRandom.current().nextInt(MIN, MAX),
				ThreadLocalRandom.current().nextBoolean(), Couleur.getRandomCouleur());
		map.put(seg.getId(), seg);
		return seg;
		// return new Segment(getRandomPoint(), ThreadLocalRandom.current().nextInt(0,
		// 50),
		// ThreadLocalRandom.current().nextBoolean());
	}

	public static Figure getRandomFigure() {
		int rand = ThreadLocalRandom.current().nextInt(4);
		if (rand == 0) {
			return getRandomCarre();
		} else if (rand == 1) {
			return getRandomRectangle();
		} else if (rand == 2) {
			return getRandomRond();
		} else {
			return getRandomSegment();
		}
	}

	public static Surfacable getRandomSurfacable() {
		int rand = ThreadLocalRandom.current().nextInt(0, 3);
		if (rand == 0) {
			return getRandomCarre();
		} else if (rand == 1) {
			return getRandomRectangle();
		} else {
			return getRandomRond();
		}
	}

	public static Collection<Point> getPoint(Figure... fig) {
		ArrayList<Point> list = new ArrayList<Point>();
		for (int i = 0; i < fig.length; i++) {
			list.addAll(fig[i].getPoint());
			// list.add(new Point());
		}
		return list;
	}

	public static Collection<Figure> genere(int n) {
		List<Figure> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(getRandomFigure());
		}
		return list;

	}

	public static Figure getFigureEn(Point p, Dessin dessin) {
//		for (Figure f : dessin.getFigure()) {
//			if (f.couvre(p)) {
//				return f;
//			}
//		}
//		return null;

		Iterator<Figure> iter = dessin.getFigure().iterator();
		while (iter.hasNext()) {
			Figure f = iter.next();
			if (f.couvre(p)) {
				return f;
			}
		}
		return null;
	}

	public static Collection<Figure> trieProcheOrigine(Dessin dessin) {
		List<Figure> figures = new ArrayList<>(dessin.getFigure());

		return figures.stream().sorted().collect(Collectors.toList());
		// Collections.sort(figures);
		//return figures;
	}

	// A ANALYSER

	public static Collection<Figure> trieSurface(Dessin dessin) {

		return dessin.getFigure().stream().filter(f -> f instanceof Surfacable).sorted((o1, o2) -> {
			Surfacable s1 = (Surfacable) o1;
			Surfacable s2 = (Surfacable) o2;
			if (s1.surface() > s2.surface()) {
				return 1;
			} else if (s1.surface() < s2.surface()) {
				return -1;
			}
			return 0;
		}).collect(Collectors.toList());

//		List<Figure> figures = new ArrayList<>(dessin.getFigure());
//		List<Figure> figureSurfacable = new ArrayList<>();
//		for (Figure tmp : figures) {
//			if (tmp instanceof Surfacable) {
//				figureSurfacable.add(tmp);
//			}
//		}
//		Collections.sort(figureSurfacable, new Comparator<Figure>() {
//			@Override
//			public int compare(Figure o1, Figure o2) {
//				Surfacable s1 = (Surfacable) o1;
//				Surfacable s2 = (Surfacable) o2;
//				if (s1.surface() > s2.surface()) {
//					return 1;
//				} else if (s1.surface() < s2.surface()) {
//					return -1;
//				}
//				return 0;
//			}
//		});
//		return figureSurfacable;
	}

	public static Figure get(String id) {

		return map.get(id);
	}

	public static void imprimable() throws ImpressionHorsLimiteException {
		for (Map.Entry<String, Figure> item : map.entrySet()) {
			for (Point p : item.getValue().getPoint()) {
				if (p.getX() < MIN || p.getX() > MAX || p.getY() < MIN || p.getY() > MAX) {
					throw new ImpressionHorsLimiteException(
							"hors limite : " + item.getKey() + " [" + p.getX() + ";" + p.getY() + "]");
				}
			}
		}
	}

	public static String afficheLigne(char car, int n) {
		String line = "";
		for (int i = 0; i < n; i++) {
			line += car;
		}
		return line;

	}

	public static void stockTab(Figure fig, char[][] tab) {
		if (fig.getType() == "ROND") {
			for (Point p : fig.getPoint()) {
				if (!(p.getX() < MIN || p.getX() > MAX || p.getY() < MIN || p.getY() > MAX)) {
					tab[p.getX()][p.getY()] = fig.getCouleur().getCode();
				}
			}
		} else {
			for (Point p : fig.getPoint()) {
				if (!(p.getX() < MIN || p.getX() > MAX || p.getY() < MIN || p.getY() > MAX)) {
					tab[p.getX()][p.getY()] = fig.getCouleur().getCode();
				}
			}
		}

	}

	public static void imprime(Dessin draw) {
		// List<Figure> figures = new ArrayList<>(draw.getFigure());
		try {
			File file = File.createTempFile("tmp_tpJava", ".txt");

			FileWriter writter = new FileWriter(file);

			System.out.println("Emplacement du fichier : " + file.getPath());

			for (Figure tmp : draw.getFigure()) {

				writter.write(tmp.toString() + System.lineSeparator());

			}

			writter.write(afficheLigne('=', 100) + System.lineSeparator());

			char tab[][] = new char[100][100];
			for (int i = 0; i < tab.length; i++) {
				for (int j = 0; j < tab[i].length; j++) {
					tab[i][j] = ' ';
				}
			}

			for (Figure fig : draw.getFigure()) {
				stockTab(fig, tab);
			}

			for (int i = 0; i < tab.length; i++) {
				writter.write(tab[i]);
				writter.write(System.lineSeparator());
			}

			Desktop.getDesktop().open(file);

			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

}
