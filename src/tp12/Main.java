package tp12;

import modele.Carre;
import modele.Point;

public class Main {

	public static void main(String[] args) {
		Point p = new Point();
		Carre carre = new Carre(p, 50);
		
		carre.affiche();

	}

}
