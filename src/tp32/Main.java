package tp32;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		ZonedDateTime date = ZonedDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss VV");
		System.out.println(date.format(format));
		/*
		 * System.out.println("Date : " + date.getDayOfMonth() + " " + date.getMonth() +
		 * " " + date.getYear() + "\nHeure : " + date.getHour() + ":" + date.getMinute()
		 * + ":" + date.getSecond() + "\nFuseaux horraire : " +
		 * date.getZone().normalized());
		 */

		// test modif git
		
		// test merge : branch

	}

}
