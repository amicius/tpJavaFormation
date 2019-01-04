package tp15;

import modele.FigureUtil;

public class Main {

	public static void main(String[] args) {
//		Segment seg = new Segment(new Point(), 20, true);
//		seg.affiche();
//		Segment seg2 = new Segment(new Point(), 42, false);
//		seg2.affiche();

		for (int i = 0; i < 10; i++) {
			FigureUtil.getRandomFigure().affiche();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("surface : " + FigureUtil.getRandomSurfacable().surface());
		}

	}

}
