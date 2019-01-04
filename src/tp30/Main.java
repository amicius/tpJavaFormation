package tp30;

import modele.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(FigureUtil.genere(20));

		// System.out.println(new Rond(new Point(), 10, Couleur.ROUGE));

		System.out.println(new Rond(new Point(), 10, Couleur.ROUGE).equals(new Rond(new Point(), 10, Couleur.ROUGE)));
		System.out.println(new Rond(new Point(), 10, Couleur.ROUGE).equals(new Rond(new Point(), 10)));
		System.out.println(new Rectangle(new Point(), 10, 10, Couleur.BLEU)
				.equals(new Rectangle(new Point(), 10, 10, Couleur.BLEU)));
		System.out.println(new Rectangle(new Point(), 10, 10, Couleur.BLEU).equals(new Rectangle(new Point(), 10, 10)));

	}

}
