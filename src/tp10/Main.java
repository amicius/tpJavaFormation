package tp10;

import modele.Point;
import modele.Rectangle;
import modele.Rond;

public class Main {

	public static void main(String[] args) {

		int x = 10, y = 10, r = 4;
		String coord;
		Point p = new Point(x, y);
		Rond rond = new Rond(p, r);
		Rectangle rect = new Rectangle(p, 10, 20);

		coord = p.toString();
		System.out.println("point : " + coord);

		rond.affiche();

		System.out.println("Point haut droit : " + rect.getPointHautDroit().toString());
		System.out.println("Point haut grauche : " + rect.getPointHautGauche().toString());
		System.out.println("Point bas grauche : " + rect.getPointBasGauche().toString());
		System.out.println("Point bas droit : " + rect.getPointBasDroit().toString());

		rect.affiche();

	}

}
