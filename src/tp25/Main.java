package tp25;

import java.util.Collection;

import modele.Dessin;
import modele.Figure;
import modele.FigureUtil;

public class Main {

	public static void main(String[] args) {

		Dessin dessin = new Dessin();
		Collection<Figure> figures = FigureUtil.genere(5);
		for (Figure f : figures) {
			dessin.add(f);
		}
		dessin.add(FigureUtil.getRandomCarre());

		System.out.println(FigureUtil.get("CARRE6"));

	}

}
