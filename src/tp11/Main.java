package tp11;
import modele.FigureUtil;
import modele.Rectangle;
import modele.Rond;

public class Main {

	public static void main(String[] args) {
		
		Rectangle rectangle;
		Rond rond;
		
		rond = FigureUtil.getRandomRond();
		rond.affiche();
		
		rectangle = FigureUtil.getRandomRectangle();
		rectangle.affiche();
	}

}
