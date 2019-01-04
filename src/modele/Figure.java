package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Figure implements Comparable<Figure>{
	
	//Point pOrigin = new Point();
	protected Couleur couleur;

	private static int cle = 0;	

	protected abstract String getType();

	public abstract String toString();
	
	public abstract boolean equals(Object obj);

	public void affiche() {
		System.out.println(toString());
	}

	public abstract Collection<Point> getPoint();

	public abstract boolean couvre(Point p);

	public double distanceOrigin() {
		List<Double> list = new ArrayList<>();
		for(Point p : this.getPoint()) {
			list.add(p.distanceOrigin());
		}
		return Collections.min(list);
	}
	
	@Override
	public int compareTo(Figure fig) {
		if (this.distanceOrigin() > fig.distanceOrigin()) {
			return 1;
		}else if (this.distanceOrigin() < fig.distanceOrigin()) {
			return -1;
		}
		return 0;}
	
	public String getId() {
		cle++;
		return this.getType()+cle;
	}
	
	public Couleur getCouleur() {
		
		return this.couleur;
	}
}
