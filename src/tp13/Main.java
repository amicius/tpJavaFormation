package tp13;

import modele.Point;

public class Main {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point(42, 51);
		
		System.out.println("p1, p2 : "+p1.equals(p2));
		System.out.println("p1, p3 : "+p1.equals(p3));
		

	}

}
