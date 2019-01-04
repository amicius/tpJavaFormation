package tp22;

import modele.*;

public class Main {

	public static void main(String[] args) {
		Point p = new Point();
		//Point ref = new Point(25, 45);
		//Rectangle rect = new Rectangle(p, 10, 10);
		//Rond rond = new Rond(p, 10);
		//Segment seg = new Segment(p, 20, false);

		// System.out.println(rect.couvre(ref));
		// System.out.println(rond.couvre(ref));
		// System.out.println(seg.couvre(ref));

		Dessin dessin = new Dessin();
		for (Figure f : FigureUtil.genere(100)) {
			dessin.add(f);
		}

		Figure result;
		result = FigureUtil.getFigureEn(p, dessin);
		if (result == null) {
			System.out.println("le point n'est pas dans une figure");
		} else {
			System.out.println("le point est dans un :");
			result.affiche();
		}
	}
}
