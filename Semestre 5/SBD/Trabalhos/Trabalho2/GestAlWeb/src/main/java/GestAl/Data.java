package GestAl;

import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Porfírio Filipe
 *
 */
public class Data {
	
static LocalDate MIN = LocalDate.MIN;  // data minima
static LocalDate MAX = LocalDate.MAX;  // data maxima

// https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
	
/*
 * https://pt.m.wikipedia.org/wiki/ISO_8601
 * The ISO-8601 calendar system is the modern civil calendar system used today in most of the world. 
 * It is equivalent to the proleptic Gregorian calendar system, in which today's rules for leap years are applied for all time. 
 * For most applications written today, the ISO-8601 rules are entirely suitable. 
 * However, any application that makes use of historical dates, 
 * and requires them to be accurate will find the ISO-8601 approach unsuitable. 
 * 
 */

/* sobre calendarios: 
 * 
 * https://www.timeanddate.com/calendar/julian-gregorian-switch.html
 * Em portugal o mês de outubro de 1582 salta 11 dias ou seja não existem os dias depois de 4 e antes de 15 
 * 
 */
	
public static String bissexto(int ano) {
	if(Year.of(ano).isLeap())
		 return "bissexto";
	return "não bissexto";
} 


public static LocalDate depoisAmanha () {
	return LocalDate.now().plusDays(2);
}

public static LocalDate anteOntem () {
	return LocalDate.now().minusDays(2);
}

public static LocalDate amanha () {
	return diaSeguinte(LocalDate.now());
}

public static LocalDate ontem () {
	return diaAnterior(LocalDate.now());
}


public static LocalDate diaSeguinte(LocalDate data) {
	return data.plusDays(1);
}

public static LocalDate diaAnterior(LocalDate data) 
{ 
  return data.minusDays(1);
}

public static long diferencaEmDias(LocalDate antes, LocalDate depois) {
  return antes.until(depois, ChronoUnit.DAYS);
}

public static long idade(LocalDate nascimento, LocalDate hoje) {
    return nascimento.until(hoje, ChronoUnit.YEARS);
}

public static LocalDate subtrairAnos(LocalDate ref, long years) {
	return ref.minusYears(years);	
}
public static LocalDate somarAnos(LocalDate ref, long years) {
	return ref.plusYears(years);	
}


public static String diaSemana(LocalDate data) {
	// The values are numbered following the ISO-8601 standard, from 1 (Monday) to 7 (Sunday)
	switch (data.getDayOfWeek().getValue()) {
	case 1: return "segunda-feira";
	case 2: return "terça-feira";
	case 3: return "quarta-feira";
	case 4: return "quinta-feira";
	case 5: return "sexta-feira";
	case 6: return "sábado";
	case 7: return "domingo";
	}
	return "?";
}

public static String right (String value, int length) {
	return value.substring(value.length() - length);
}

public static String show(LocalDate dt) {
	return right("0" + dt.getDayOfMonth(),2) + "/" + right("0"+(dt.getMonthValue()),2) + "/" + dt.getYear();
}

public static String showISO(LocalDate dt) {
	return dt.getYear() + "-" + right("0"+(dt.getMonthValue()),2) + "-" + right("0" + dt.getDayOfMonth(),2);
}

public static LocalDate convertToLocalDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
}

public static String saber(Date data) {
	return saber(convertToLocalDate(data));
}

public static String saber(LocalDate data) {
	return "tem " +idade(data, LocalDate.now())+" anos de idade, já viveu "+diferencaEmDias(data, LocalDate.now())+
	" dias, nasceu, na véspera de "+show(diaSeguinte(data))+", num"+
	((diaSemana(data).compareToIgnoreCase("domingo")==0||diaSemana(data).compareToIgnoreCase("sábado")==0)?"":"a")+
	" "+diaSemana(data)+" de um ano "+bissexto(data.getYear()); // +"."
}

public static String saber(String data) {  
	//  ISO 8601 (https://www.progress.com/blogs/understanding-iso-8601-date-and-time-format)
	if(data!=null && data.compareTo("")!=0) {
		LocalDate ld = LocalDate.parse(data);
		if(ld!=null)
			return saber(ld);
	}
	return "?";
}

public static long epochDay() {
	LocalDate d = LocalDate.now();
	long epoch=-1;
	epoch = d.toEpochDay();
	return epoch;
}
	
public static String era() {
	LocalDate d = LocalDate.now();
	return d.getEra().getDisplayName(TextStyle.FULL,Locale.UK);
}


// https://en.m.wikipedia.org/wiki/ISO_week_date#Calculating_the_week_number_of_a_given_date
public static void numeroDaSemana () {
	ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
	System.out.printf("Week %d%n", now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
}

public static void descreveCalendar () { // classe legada
	System.out.println("========= Demo Calendar ===========");
	Calendar c = Calendar.getInstance(  );    // today
	System.out.println("Year: " + c.get(Calendar.YEAR));
	System.out.println("Month: " + c.get(Calendar.MONTH));
	System.out.println("Day: " + c.get(Calendar.DAY_OF_MONTH));
	System.out.println("Day of week = " + c.get(Calendar.DAY_OF_WEEK));
	System.out.println("Day of year = " + c.get(Calendar.DAY_OF_YEAR));
	System.out.println("Week in Year: " + c.get(Calendar.WEEK_OF_YEAR));
	System.out.println("Week in Month: " + c.get(Calendar.WEEK_OF_MONTH));
	System.out.println("Day of Week in Month: " + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	System.out.println("Hour: " + c.get(Calendar.HOUR));
	System.out.println("AM or PM: " + c.get(Calendar.AM_PM));
	System.out.println("Hour (24-hour clock): " +  c.get(Calendar.HOUR_OF_DAY));
	System.out.println("Minute: " + c.get(Calendar.MINUTE));
	System.out.println("Second: " + c.get(Calendar.SECOND));
	System.out.println("===================================");
}

public static void descreve (String MyDate, PrintWriter out) {
	LocalDate dt = LocalDate.parse(MyDate);
	out.println("===================================");
	out.println("Referência ("+(dt.isLeapYear()?"bissexto":"não bissexto")+"): "+MyDate);
	out.println("-----------------------------------");
	out.println("Ano anterior < "+dt.plusYears(-1));
	out.println("Ano seguinte > "+dt.plusYears(1));
	out.println("Mês anterior < "+dt.minusMonths(1));
	out.println("Mês seguinte > "+dt.minusMonths(-1));
	out.println("Dia anterior < "+dt.minusDays(1));
	out.println("Dia seguinte > "+dt.plusDays(1));
	out.println("===================================");
	out.flush();
}

public static void descreve(String MyDate) {
	descreve (MyDate, new PrintWriter(System.out));
}
	/**
	 * @param args
	 */
public static void main(String[] args) {
		descreve("2004-02-29");
		descreve("2005-02-28");

		descreveCalendar();
		
		LocalDate today = LocalDate.now();
	    System.out.println("Data de hoje: "+today);
	    System.out.println(saber("1965-09-08"));
	    System.out.println("epoch day: "+epochDay());
	    System.out.println("era: "+era());
	    System.out.println("Data Minima: "+show(MIN));
	    System.out.println("Data Máxima: "+show(MAX));
	    
	}
}
