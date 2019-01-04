package tp31;

import java.util.HashMap;
import java.util.Map;

import modele.Dessin;
import modele.Figure;
import modele.FigureUtil;

public class Main {

	public static void main(String[] args) {

		Map<Integer, Integer> number = new HashMap<>();
		number.put(1324, 1324);
		number.put(1, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, null);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		number.put(1324, 1324);
		System.out.println(number.entrySet().stream().filter(i -> i != null && i.getValue() != null)
				.map(i -> i.getValue()).reduce((n, i) -> n * i).orElse(10));

//		String res = "";
//		boolean first = true;
//		for (Integer i : number) {
//			if (i != null) {
//				if (first) {
//					res = i.toString();
//					first = false;
//				} else {
//					res += ", " + i.toString();
//				}
//			}
//		}
//		if (!res.equals("")) {
//			System.out.println(res);
//		} else {
//			System.out.println("vide");
//		}
//
//		System.out.println(number.stream().filter(i -> i != null).map(i -> i.toString()).reduce((n, i) -> n + ", " + i)
//				.orElse("vide"));

		Dessin draw = new Dessin();
		for (Figure fig : FigureUtil.genere(20)) {
			draw.add(fig);
		}
		FigureUtil.imprime(draw);
	}

}
