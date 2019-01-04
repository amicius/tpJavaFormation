package tp24;

import java.util.Collection;

import modele.Dessin;
import modele.Figure;
import modele.FigureUtil;
import modele.Surfacable;

public class Main {

	public static void main(String[] args) {
		
		Dessin dessin = new Dessin();
		Collection<Figure> figures = FigureUtil.genere(5);
		for (Figure f : figures) {
			dessin.add(f);
		}
		
		Collection<Figure> fs = FigureUtil.trieProcheOrigine(dessin);
		for (Figure ft : fs) {
			System.out.println("distance origine : " + ft.distanceOrigin());
		}

		Collection<Figure> fs1 = FigureUtil.trieSurface(dessin);
		for (Figure ft : fs1) {
			System.out.println("surface : " + ((Surfacable) ft).surface());
		}
	}

}
