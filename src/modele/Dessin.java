package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dessin { // choix d'une ArrayList : pas de cl� de valeur, possible doublon, pas d'acc�s
						// qu'en d�but et fin

	List<Figure> list;

	public Dessin() {
		list = new ArrayList<>();
	}

	public boolean add(Figure fig) {
		return list.add(fig);
	}

	public Collection<Figure> getFigure() {
		return list;
	}
}
