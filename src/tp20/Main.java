package tp20;

import modele.Figure;
import modele.FigureUtil;

public class Main {

	public static void main(String[] args) {
		Figure[] fig = new Figure[10];
		for (int i = 0; i < fig.length; i++) {
			fig[i] = FigureUtil.getRandomFigure();
		}
		
		System.out.println(FigureUtil.getPoint(fig));
	
			
		

	}

}
