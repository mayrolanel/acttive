package br.com.cursocucumber.test.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverterString {
	
	public static String converteDataParaString(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(data);
	}
}