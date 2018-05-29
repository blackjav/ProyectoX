package com.liverpool.cebt.utils;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class Utils {
	
public  String leerPropiedad (String propiedad){
		
		String propiedadEncontrada="";
		try
		{
			Properties props = new Properties();        
	        InputStream fis = getClass().getResourceAsStream("/proyect.properties");
	        props.load(fis);
	        propiedadEncontrada = props.getProperty(propiedad);
		}
		catch (Exception e) 
		{
			System.out.println("ERROR UTIL "+e.getMessage());
		}
		
		return propiedadEncontrada;
    }

public static Boolean ValidarFechaPosterior(String fecha) throws  java.text.ParseException {

	
	DateFormat formatter = null;
	Date fechaConvertida = null;

	Boolean posterior = false;

	Date hoy = new Date();

	Calendar cal = Calendar.getInstance();
	cal.setTime(hoy);

	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	hoy = cal.getTime();

	formatter = new SimpleDateFormat("yyyyMMdd");
	fechaConvertida = (Date) formatter.parse(fecha);

	if (fechaConvertida.compareTo(hoy) < 0) {
		posterior = false;

	} else if (fechaConvertida.compareTo(hoy) >= 0) {
		posterior = true;

	}

	return posterior;

}

public static Boolean validarFechaInicialVigencia(Date fechaSelecionada, String fechaAlta) throws java.text.ParseException {

	System.out.println("\nVerificando fecha inicial de vigencia");
	
	DateFormat formatter = null;
	Date fechaConvertidaAlta = null;

	Boolean posterior = false;

	Calendar cal = Calendar.getInstance();
	cal.setTime(fechaSelecionada);

	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	fechaSelecionada = cal.getTime();

	formatter = new SimpleDateFormat("yyyyMMdd");
	fechaConvertidaAlta = (Date) formatter.parse(fechaAlta);

	if (fechaConvertidaAlta.compareTo(fechaSelecionada) <= 0) {
		System.out.println("la fecha seleccionada es posterior a la fecha inicial de vigencia");
		posterior = true;

	} else if (fechaConvertidaAlta.compareTo(fechaSelecionada) > 0) {
		System.out.println("la fecha inicial de vigencia es posterior a la fecha seleccinada");

	}

	return posterior;

}

}
