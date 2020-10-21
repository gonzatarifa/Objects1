package test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestLocalDateyLocalTime {
	public static void main(String[] args) {
		
		LocalDate fecha = LocalDate.of(2019, 3, 19);
		LocalDate fecha1 = fecha.minusDays(5);
		LocalDate fecha2 = fecha1.plusMonths(4);
		
		System.out.println("Primer fecha: " + fecha.getMonthValue() + "/" + fecha.getYear());
		System.out.println("Segunda fecha: " + fecha1.getDayOfMonth() + "/" + fecha.getYear());
		System.out.println("Tercer fecha: " + fecha2.getMonthValue() + "/" + fecha.getYear());
		
		System.out.println("La primer fecha es anterior a la segunda?: " + fecha.isBefore(fecha1));
		System.out.println("Y la segunda a la tercera?: " + fecha1.isBefore(fecha2));
		System.out.println("Y la primer fecha es posterior a la segunda?: " + fecha.isAfter(fecha1));
		System.out.println("Y la segunda a la tercera?: " + fecha1.isAfter(fecha2));
		
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora.getHour() + ":" + ahora.getMinute());
	}
}
