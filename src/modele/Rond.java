package modele;

import java.util.ArrayList;
import java.util.Collection;

public class Rond extends Figure implements Surfacable {

	private Point p;
	private int r;

	public Rond(Point p, int r) {
		this.p = p;
		this.r = r;
		couleur = Couleur.getCouleurDefaut();		
	}
	
	public Rond(Point p, int r, Couleur couleur) {
		this(p, r);
		this.couleur = couleur;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rond other = (Rond) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (r != other.r)
			return false;
		return true;
	}

	protected String getType() {
		return "ROND";
	}

	public String toString() {
		return "[" + getType() + " "+getCouleur()+" " + p + "," + r + "]";
	}

	@Override
	public double surface() {
		return Math.PI * Math.pow(r, 2);
	}

	public Collection<Point> getPoint() {
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(p);
		return list;
	}

	@Override
	public boolean couvre(Point p) {
		return this.p.distance(p) <= this.r;
	}

//	@Override
//	public double distanceOrigin() {
//		
//		return p.distance(pOrigin);
//	}

//	public void affiche() {
//		System.out.println(toString());
//		return;
//	}

}
