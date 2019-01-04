package modele;

import java.util.ArrayList;
import java.util.Collection;

public class Segment extends Figure {
	private Point debut;
	private Point fin;

	public Segment(Point debut, int longeur, boolean horizontal) {
		this.debut = debut;
		if (horizontal) {
			fin = new Point(debut.getX() + longeur, debut.getY());
		} else {
			fin = new Point(debut.getX(), debut.getY() + longeur);
		}
		couleur = Couleur.getCouleurDefaut();
	}

	public Segment(Point debut, int longeur, boolean horizontal, Couleur couleur) {
		this(debut, longeur, horizontal);
		this.couleur = couleur;
	}

	protected String getType() {
		return "Segment";
	}

	public String toString() {
		return "[" + getType() + " " + getCouleur() + " [" + debut.getX() + ";" + debut.getY() + "],[" + fin.getX()
				+ ";" + fin.getY() + "]]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segment other = (Segment) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
			return false;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		return true;
	}

	@Override
	public Collection<Point> getPoint() {
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(debut);
		list.add(fin);
		return list;
	}

	@Override
	public boolean couvre(Point p) {
		return ((debut.getY() == p.getY() && p.getX() >= debut.getX() && p.getX() <= fin.getX())
				|| (debut.getX() == p.getX() && p.getY() >= debut.getY() && p.getY() <= fin.getY()));
	}

//	@Override
//	public double distanceOrigin() {
//		double dist = debut.distance(pOrigin);
//		if (fin.distance(pOrigin)<dist) {
//			dist = fin.distance(pOrigin);
//		}
//		return dist;
//	}

}
