package modele;

import java.util.ArrayList;
import java.util.Collection;

public class Rectangle extends Figure implements Surfacable {
	private Point pointBasGauche, pointBasDroit, pointHautGauche, pointHautDroit;

	public Rectangle(Point p, int x, int y) {
		pointBasGauche = p;
		pointHautGauche = new Point(p.getX(), p.getY() + y);
		pointBasDroit = new Point(p.getX() + x, p.getY());
		pointHautDroit = new Point(p.getX() + x, p.getY() + y);
		couleur = Couleur.getCouleurDefaut();
	}

	public Rectangle(Point p, int x, int y, Couleur couleur) {
		this(p, x, y);
		this.couleur = couleur;
	}

	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroit() {
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		return pointHautGauche;
	}

	public Point getPointHautDroit() {
		return pointHautDroit;
	}

	protected String getType() {
		return "RECT";
	}

	public String toString() {
		return "[" + getType() + " " + getCouleur() + " " + pointHautGauche + pointHautDroit + pointBasGauche
				+ pointBasDroit + "]";
	}

	@Override
	public double surface() {
		int a = Math.abs(pointHautDroit.getX() - pointBasGauche.getX())
				* Math.abs(pointHautDroit.getY() - pointBasGauche.getY());
		return a;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (pointBasDroit == null) {
			if (other.pointBasDroit != null)
				return false;
		} else if (!pointBasDroit.equals(other.pointBasDroit))
			return false;
		if (pointBasGauche == null) {
			if (other.pointBasGauche != null)
				return false;
		} else if (!pointBasGauche.equals(other.pointBasGauche))
			return false;
		if (pointHautDroit == null) {
			if (other.pointHautDroit != null)
				return false;
		} else if (!pointHautDroit.equals(other.pointHautDroit))
			return false;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (pointHautGauche == null) {
			if (other.pointHautGauche != null)
				return false;
		} else if (!pointHautGauche.equals(other.pointHautGauche))
			return false;
		return true;
	}

	@Override
	public Collection<Point> getPoint() {
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(pointBasGauche);
		list.add(pointBasDroit);
		list.add(pointHautDroit);
		list.add(pointHautGauche);
		return list;
	}

	@Override
	public boolean couvre(Point p) {

		return (p.getX() <= pointBasDroit.getX() && p.getX() >= pointBasGauche.getX())
				&& (p.getY() <= pointHautGauche.getY() && p.getY() >= pointBasGauche.getY());
	}

//	@Override
//	public double distanceOrigin() {
//		double dist = pointBasDroit.distance(pOrigin);
//		if (pointBasGauche.distance(pOrigin) < dist) {
//			dist = pointBasGauche.distance(pOrigin);
//		} else if (pointHautDroit.distance(pOrigin) < dist) {
//			dist = pointHautDroit.distance(pOrigin);
//		} else if (pointHautGauche.distance(pOrigin) < dist) {
//			dist = pointHautGauche.distance(pOrigin);
//		}
//		return dist;
//	}

//	public void affiche() {
//		System.out.println(toString());
//		return;
//	}

}
