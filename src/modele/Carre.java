package modele;

public class Carre extends Rectangle{

	public Carre(Point p, int x) {
		super(p, x, x);
	}
	
	public Carre(Point p, int x, Couleur couleur) {
		super(p, x, x, couleur);
	}

	protected String getType() {
		return "CARRE";
	}

}
