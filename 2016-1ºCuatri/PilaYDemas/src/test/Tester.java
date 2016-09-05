package test;

import interfaces.Cola;
import interfaces.Pila;

import java.util.Calendar;
import java.util.GregorianCalendar;

import principal.ColaCL;
import principal.ColaHL;
import principal.PilaCL;
import principal.PilaHL;
import utils.FileUtils;
import clasesBases.ColaEstatica;
import clasesBases.PilaEstatica;

import complejo.Complejo;

import exceptions.ColaException;
import exceptions.PilaException;

public class Tester {

	
	public static void enterosPilaE(String path){
		
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Pila<Integer> PilaE = new PilaEstatica<Integer>();
		
		// Apilar
		Calendar tInicioApilaPilaE = new GregorianCalendar();
		for(int i=1;i<1000000;i++){
			PilaE.apilar(loteEntrada[i]);
		}
		Calendar tFinApilaPilaE = new GregorianCalendar();
		long diffApila = (tFinApilaPilaE.getTimeInMillis() - tInicioApilaPilaE.getTimeInMillis());
		cadena="Tiempo de proceso PilaE APILA: "+ loteEntrada[0] +" enteros en "+  diffApila + "ms\r\n";
		// DesApilar
		Calendar tInicioDesapilaPilaE = new GregorianCalendar();
			for(int i=1;i<loteEntrada[0];i++)
					PilaE.desapilar();
			
		Calendar tFinDesapilaPilaE = new GregorianCalendar();
		
		long diffDesapilaPilaE = (tFinDesapilaPilaE.getTimeInMillis() - tInicioDesapilaPilaE.getTimeInMillis());
		cadena+="Tiempo de proceso PilaE DESAPILA:"+ loteEntrada[0] +" enteros en "+  diffDesapilaPilaE + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\EnterosPilaE.out", cadena);
	}
	
	public static void enterosPilaHL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Pila<Integer> PilaHL = new PilaHL<Integer>();
		Calendar tInicioApilaPilaHL = new GregorianCalendar();
		 // Apila
		 for(int i=1;i<loteEntrada[0];i++){
			 PilaHL.apilar(i);
		 }
		 Calendar tfinApilaPilaHL = new GregorianCalendar();
		
		 long diffApilaPilaHL = (tfinApilaPilaHL.getTimeInMillis() - tInicioApilaPilaHL.getTimeInMillis());
		 cadena="Tiempo de proceso PilaHL APILA:"+ loteEntrada[0] +" enteros en "+  diffApilaPilaHL + "ms\r\n";
		 
		 
		 // Desapila
		Calendar tInicioDespilaPilaHL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++){
				PilaHL.desapilar();
		}
		Calendar tFinDespilaPilaHL = new GregorianCalendar();
		
		
		long diff2 = (tFinDespilaPilaHL.getTimeInMillis() - tInicioDespilaPilaHL.getTimeInMillis());
		
		cadena+="Tiempo de proceso PilaHL DESAPILA: "+ loteEntrada[0] +" enteros en "+  diff2 + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\EnterosPilaHL.out", cadena);
	}
	
	public static void enterosPilaCL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		
		Pila<Integer> PilaCL = new PilaCL<Integer>();
		
		//Apila
		Calendar tInicioApilaPilaCL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++)
			PilaCL.apilar(i);
		Calendar tFinApilaPilaCL = new GregorianCalendar();

		long diffApilaPilaCL = (tFinApilaPilaCL.getTimeInMillis() - tInicioApilaPilaCL.getTimeInMillis());
		cadena="Tiempo de proceso PilaCL APILA: "+ loteEntrada[0] +" enteros en "+  diffApilaPilaCL + "ms\r\n";
		// Desapila
		Calendar tInicioDespilaPilaCL = new GregorianCalendar();	
			for(int i=1;i<loteEntrada[0];i++)
					PilaCL.desapilar();
		
		Calendar tFinDespilaPilaCL = new GregorianCalendar();
		
		long diffDesapilaPilaCL = (tFinDespilaPilaCL.getTimeInMillis() - tInicioDespilaPilaCL.getTimeInMillis());
	
		cadena+="Tiempo de proceso PilaCL DESAPILA: "+ loteEntrada[0] +" enteros en "+  diffDesapilaPilaCL + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\EnterosPilaCL.out", cadena);
	}
	public static void enterosColaE(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Cola<Integer> colaE = new ColaEstatica<Integer>();
		
		// Ar
		Calendar tInicioAcolarColaE = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++){
			colaE.acolar(i);
		}
		Calendar tFinAcolarColaE = new GregorianCalendar();
		long diffAcola = (tFinAcolarColaE.getTimeInMillis() - tInicioAcolarColaE.getTimeInMillis());
		cadena="Tiempo de proceso ColaE ACOLA: "+ loteEntrada[0] +" enteros en "+  diffAcola + "ms\r\n";
		// DesApilar
		Calendar tInicioDesencolaColaE = new GregorianCalendar();
			for(int i=1;i<loteEntrada[0];i++)
					colaE.desacolar();
			
		Calendar tFinDesencolaColaE = new GregorianCalendar();
		
		long diffDesencolaColaE = (tFinDesencolaColaE.getTimeInMillis() - tInicioDesencolaColaE.getTimeInMillis());
	
		cadena+="Tiempo de proceso ColaE DESACOLA:"+ loteEntrada[0] +" enteros en "+  diffDesencolaColaE + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\EnterosColaE.out", cadena);	
	}
	public static void enterosColaHL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Cola<Integer> colaHL = new ColaHL<Integer>();
		
		// Acola
		Calendar tInicioAcolaColaHL = new GregorianCalendar();
		for(int i=1;i<=loteEntrada[0];i++)
			{colaHL.acolar(i);}
		Calendar tFinAcolaColaHL = new GregorianCalendar();
		
		long diffAcolaColaHL = (tFinAcolaColaHL.getTimeInMillis() - tInicioAcolaColaHL.getTimeInMillis());
		cadena="Tiempo de proceso ColaHL ACOLA: "+ loteEntrada[0]+" enteros en "+  diffAcolaColaHL + "ms\r\n";
		// Desacola
		Calendar tInicioDesacolaColaHL = new GregorianCalendar();
			for(int i=1;i<loteEntrada[0];i++)
					colaHL.desacolar();

			Calendar tFinDescolaColaHL = new GregorianCalendar();
		
		long diffDesacolaColaHL = (tFinDescolaColaHL.getTimeInMillis() - tInicioDesacolaColaHL.getTimeInMillis());
	
		cadena+="Tiempo de proceso ColaHL DESACOLA: "+ loteEntrada[0] +" enteros en "+  diffDesacolaColaHL + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\EnterosColaHL.out", cadena);
	}
	public static void enterosColaCL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Cola<Integer> colaCL = new ColaCL<Integer>();
		
		//Acola
		Calendar tInicioAcolaColaCL = new GregorianCalendar();
		for(int i=1;i<=loteEntrada[0];i++)
			{colaCL.acolar(i);}
		Calendar tFinAcolaColaCL = new GregorianCalendar();

		long diffAcolaColaCL = (tFinAcolaColaCL.getTimeInMillis() - tInicioAcolaColaCL.getTimeInMillis());
		cadena="Tiempo de proceso ColaCL ACOLA: "+ loteEntrada[0] +" enteros en "+  diffAcolaColaCL + "ms\r\n";
		// Desacola
		Calendar tInicioDesacolaColaCL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++)
				colaCL.desacolar();

		Calendar tFinDesacolaColaCL = new GregorianCalendar();
		
		long diffDesacolaColaCL = (tFinDesacolaColaCL.getTimeInMillis() - tInicioDesacolaColaCL.getTimeInMillis());
	
		cadena+="Tiempo de proceso ColaCL DESACOLA: "+ loteEntrada[0] +" enteros en "+  diffDesacolaColaCL + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\EnterosColaCL.out", cadena);
	}
	
	public static void complejosPilaE(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Pila<Complejo> PilaE = new PilaEstatica<Complejo>();
		
		// Apilar
		Calendar tInicioApilaPilaE = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++){
			PilaE.apilar(new Complejo(loteEntrada[i],loteEntrada[i]));
		}
		Calendar tFinApilaPilaE = new GregorianCalendar();
		long diffApila = (tFinApilaPilaE.getTimeInMillis() - tInicioApilaPilaE.getTimeInMillis());
		
		cadena= "Tiempo de proceso PilaE APILA : "+ loteEntrada[0] +" complejos en "+  diffApila + "ms\r\n";
	
		
		// DesApilar
		Calendar tInicioDesapilaPilaE = new GregorianCalendar();
			for(int i=1;i<loteEntrada[0];i++)
				PilaE.desapilar();
		
			Calendar tFinDesapilaPilaE = new GregorianCalendar();
		
		long diffDesapilaPilaE = (tFinDesapilaPilaE.getTimeInMillis() - tInicioDesapilaPilaE.getTimeInMillis());
		cadena+="Tiempo de proceso PilaE DESAPILA:"+ loteEntrada[0] +" complejos en "+  diffDesapilaPilaE + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\ComplejosPilaE.out", cadena);
		
	}
	public static void complejosPilaHL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		
		Pila<Complejo> PilaHL = new PilaHL<Complejo>();
		Calendar tInicioApilaPilaHL = new GregorianCalendar();
		 // Apila
		 for(int i=1;i<loteEntrada[0];i++){
			 PilaHL.apilar(new Complejo(loteEntrada[i],loteEntrada[i]));
		 }
		 Calendar tfinApilaPilaHL = new GregorianCalendar();
		
		 long diffApilaPilaHL = (tfinApilaPilaHL.getTimeInMillis() - tInicioApilaPilaHL.getTimeInMillis());
				 
		 cadena="Tiempo de proceso PilaHL APILA:"+ loteEntrada[0] +" complejos en "+  diffApilaPilaHL + "ms\r\n";
		 
		 // Desapila
		Calendar tInicioDespilaPilaHL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++){
				PilaHL.desapilar();
		}
		Calendar tFinDespilaPilaHL = new GregorianCalendar();
		
		
		long diff2 = (tFinDespilaPilaHL.getTimeInMillis() - tInicioDespilaPilaHL.getTimeInMillis());
	
		cadena+="Tiempo de proceso PilaHL DESAPILA: "+ loteEntrada[0] +" complejos en "+  diff2 + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\ComplejosPilaHL.out", cadena);
	}
	public static void complejosPilaCL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Pila<Complejo> PilaCL = new PilaCL<Complejo>();
		
		//Apila
		Calendar tInicioApilaPilaCL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++)
			PilaCL.apilar(new Complejo(loteEntrada[i],loteEntrada[i]));
		Calendar tFinApilaPilaCL = new GregorianCalendar();

		long diffApilaPilaCL = (tFinApilaPilaCL.getTimeInMillis() - tInicioApilaPilaCL.getTimeInMillis());
		cadena="Tiempo de proceso PilaCL APILA: "+ loteEntrada[0] +" complejos en "+  diffApilaPilaCL + "ms\r\n";
		// Desapila
		Calendar tInicioDespilaPilaCL = new GregorianCalendar();	
			for(int i=1;i<loteEntrada[0];i++)
					PilaCL.desapilar();
	
		Calendar tFinDespilaPilaCL = new GregorianCalendar();
		
		long diffDesapilaPilaCL = (tFinDespilaPilaCL.getTimeInMillis() - tInicioDespilaPilaCL.getTimeInMillis());
	
		cadena+="Tiempo de proceso PilaCL DESAPILA: "+ loteEntrada[0] +" complejos en "+  diffDesapilaPilaCL + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\ComplejosPilaCL.out", cadena);
	}
	public static void complejosColaE(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		Cola<Complejo> colaE = new ColaEstatica<Complejo>();
		
		// Ar
		Calendar tInicioAcolarColaE = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++){
			colaE.acolar(new Complejo(loteEntrada[i],loteEntrada[i]));
		}
		Calendar tFinAcolarColaE = new GregorianCalendar();
		long diffAcola = (tFinAcolarColaE.getTimeInMillis() - tInicioAcolarColaE.getTimeInMillis());
		cadena="Tiempo de proceso ColaE ACOLA: "+ loteEntrada[0] +" complejos en "+  diffAcola + "ms\r\n";
		// DesApilar
		Calendar tInicioDesencolaColaE = new GregorianCalendar();
			for(int i=1;i<loteEntrada[0];i++)
					colaE.desacolar();

			Calendar tFinDesencolaColaE = new GregorianCalendar();
		
		long diffDesencolaColaE = (tFinDesencolaColaE.getTimeInMillis() - tInicioDesencolaColaE.getTimeInMillis());
	
		cadena+="Tiempo de proceso ColaE DESACOLA:"+ loteEntrada[0] +" complejos en "+  diffDesencolaColaE + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\ComplejosColaE.out", cadena);
	}
	public static void complejosColaHL(String path){
		int[] loteEntrada= FileUtils.leerArchivo(path);
		String cadena;
		
		Cola<Complejo> colaHL = new ColaHL<Complejo>();
		
		// Acola
		Calendar tInicioAcolaColaHL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++)
			{colaHL.acolar(new Complejo(loteEntrada[i],loteEntrada[i]));}
		Calendar tFinAcolaColaHL = new GregorianCalendar();
		
		long diffAcolaColaHL = (tFinAcolaColaHL.getTimeInMillis() - tInicioAcolaColaHL.getTimeInMillis());
		cadena="Tiempo de proceso ColaHL ACOLA: "+ loteEntrada[0]+" complejos en "+  diffAcolaColaHL + "ms\r\n";
		// Desacola
		Calendar tInicioDesacolaColaHL = new GregorianCalendar();
			for(int i=1;i<loteEntrada[0];i++)
					colaHL.desacolar();

			Calendar tFinDescolaColaHL = new GregorianCalendar();
		
		long diffDesacolaColaHL = (tFinDescolaColaHL.getTimeInMillis() - tInicioDesacolaColaHL.getTimeInMillis());
	
		cadena+="Tiempo de proceso ColaHL DESACOLA: "+ loteEntrada[0] +" complejos en "+  diffDesacolaColaHL + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\ComplejosColaHL.out", cadena);
	}
	public static void complejosColaCL(String path){
		int[] loteEntrada= FileUtils.leerArchivo("..\\Prueba\\IN\\LoteDeEntrada.in");
		String cadena;
		Cola<Complejo> colaCL = new ColaCL<Complejo>();
		
		//Acola
		Calendar tInicioAcolaColaCL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++)
			{colaCL.acolar(new Complejo(loteEntrada[i],loteEntrada[i]));}
		Calendar tFinAcolaColaCL = new GregorianCalendar();

		long diffAcolaColaCL = (tFinAcolaColaCL.getTimeInMillis() - tInicioAcolaColaCL.getTimeInMillis());
		cadena="Tiempo de proceso ColaCL ACOLA: "+ loteEntrada[0] +" complejos en "+  diffAcolaColaCL + "ms\r\n";
		// Dsesacola
		Calendar tInicioDesacolaColaCL = new GregorianCalendar();
		for(int i=1;i<loteEntrada[0];i++)
				colaCL.desacolar();

		Calendar tFinDesacolaColaCL = new GregorianCalendar();
		
		long diffDesacolaColaCL = (tFinDesacolaColaCL.getTimeInMillis() - tInicioDesacolaColaCL.getTimeInMillis());
	
		cadena+="Tiempo de proceso ColaCL DESACOLA: "+ loteEntrada[0] +" complejos en "+  diffDesacolaColaCL + "ms";
		System.out.println(cadena);
		FileUtils.escribirArchivo("..\\Prueba\\OUT\\ComplejosColaCL.out", cadena);
	}
}
