package unidad6Ej06;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FichaTecnica {
	public double datoFijo;
	public double datoIterante;
	public double cantidadIteraciones;
	
	public FichaTecnica(double datoFijo, double datoIterante, double cantidadIteraciones) {
		super();
		this.datoFijo = datoFijo;
		this.datoIterante = datoIterante;
		this.cantidadIteraciones = cantidadIteraciones;
		
	}
	
	public void Suma(){
		double diferencia;
		Calendar tiempoInicialSuma= new GregorianCalendar();
		for (int i = 0; i < cantidadIteraciones; i++){
			datoIterante+=datoFijo;
		}
		Calendar tiempoFinalSuma = new GregorianCalendar();
		diferencia = tiempoFinalSuma.getTimeInMillis() - tiempoInicialSuma.getTimeInMillis();
		System.out.println("el tiempo que tarda en resolver es: " +diferencia); 
	}
	
	public void Multiplicacion(){
		double diferencia;
		Calendar tiempoInicialSuma= new GregorianCalendar();
		for (int i = 0; i < cantidadIteraciones; i++){
			datoIterante*=datoFijo;
		}
		Calendar tiempoFinalSuma = new GregorianCalendar();
		diferencia = tiempoFinalSuma.getTimeInMillis() - tiempoInicialSuma.getTimeInMillis();
		System.out.println("el tiempo que tarda en resolver es: " +diferencia); 
	}
	public void Division(){
		double diferencia;
		Calendar tiempoInicialSuma= new GregorianCalendar();
		for (int i = 0; i < cantidadIteraciones; i++){
			datoIterante/=datoFijo;
		}
		Calendar tiempoFinalSuma = new GregorianCalendar();
		diferencia = tiempoFinalSuma.getTimeInMillis() - tiempoInicialSuma.getTimeInMillis();
		System.out.println("el tiempo que tarda en resolver es: " +diferencia); 
	}
	public void Comparaciones(){
		double diferencia;
		Calendar tiempoInicialSuma= new GregorianCalendar();
		for (int i = 0; i < cantidadIteraciones; i++){
			if (datoIterante == datoFijo)
				datoIterante = datoFijo;
		}
		Calendar tiempoFinalSuma = new GregorianCalendar();
		diferencia = tiempoFinalSuma.getTimeInMillis() - tiempoInicialSuma.getTimeInMillis();
		System.out.println("el tiempo que tarda en resolver es: " +diferencia); 
	}
	public void Asignaciones(){
		double diferencia;
		Calendar tiempoInicialSuma= new GregorianCalendar();
		for (int i = 0; i < cantidadIteraciones; i++){
			datoIterante = datoFijo;
		}
		Calendar tiempoFinalSuma = new GregorianCalendar();
		diferencia = tiempoFinalSuma.getTimeInMillis() - tiempoInicialSuma.getTimeInMillis();
		System.out.println("el tiempo que tarda en resolver es: " +diferencia); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FichaTecnica a = new FichaTecnica(3,4,1000000000);
		a.Suma();
		a.Multiplicacion();
		a.Division();
		a.Comparaciones();
		a.Asignaciones();
				
	}
	
	
	


}
