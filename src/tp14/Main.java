package tp14;

import modele.FigureUtil;

public class Main {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			FigureUtil.getRandomFigure().affiche();
		}

	}

}
