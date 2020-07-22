package br.com.cursocucumber.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static String obterDataConvertidaParaString(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(data);
	}
	
	public static Calendar obterDataConvertidaParaCalendar(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		
		return calendar;
	}
	
	public static Date obterDataDiferencaDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		
		return calendar.getTime();
	}
	
	public static Date obterDataAtual() {
		Calendar calendar = Calendar.getInstance();
		
		return calendar.getTime();
	}
}