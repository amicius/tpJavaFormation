package modele;

import java.util.concurrent.ThreadLocalRandom;

public enum Couleur {
	ROUGE('R'), VERT('V'), BLEU('B'), JAUNE('J'), NOIR('N');

	private char code;

	private Couleur(char code) {
		this.code = code;
	}

	public static Couleur getCouleurDefaut() {
		return NOIR;
	}

	public static Couleur getRandomCouleur() {
		return values()[ThreadLocalRandom.current().nextInt(values().length)];
	}

	public char getCode() {
		return code;
	}

}
