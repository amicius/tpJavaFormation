package tp26;

import java.util.Collection;

import modele.Dessin;
import modele.Figure;
import modele.FigureUtil;
import modele.ImpressionHorsLimiteException;

public class Main {

	public static void main(String[] args) {
		Dessin dessin = new Dessin();
		Collection<Figure> figures = FigureUtil.genere(100);
		for (Figure f : figures) {
			dessin.add(f);
		}

		try {
			FigureUtil.imprimable();
		}catch (ImpressionHorsLimiteException e) {
			System.out.println("Impression limite detecte : "+e.getMessage());
		}
	}

}
