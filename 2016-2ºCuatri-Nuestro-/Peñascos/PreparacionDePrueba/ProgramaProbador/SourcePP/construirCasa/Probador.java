package construirCasa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/////////////////////////////////////////////////////////////////////////////////////////
/*
31-08 Modificacion Propuesta por Braian
		Cambiar el nombre del objeto sc por scIn para un nombre mas significativo
		Correcciones a realizar: el metodo Probador.probarFalso no comprueba si nos salimos de las dimennsiones 
		de la matriz, posible solucion agregar un try catch que capture ese error, y notificar que el programa funciona mal
		.



*/
/////////////////////////////////////////////////////////////////////////////////////////



public class Probador {
   
	// DATOS DEL .IN
	private int DX;				   //Coordenada en x del terreno
	private int DY;				   // Coordenada en y del terreno
	private int F;				   // Frente de la casa  <- la puerta se posiciona aca.
	private int L; 		  		   // Profundidad de la casa 
	private int cantPeñasco;	   // obvi nene
	private boolean [][] terreno;  // MATRIZ BOOLEANA CON lOS PEÑASCOS:
																   // TRUE   = HAY PEÑASCO
																   // FASLSE = NO HAY PEÑASCO

	
	//DATOS DEL .OUT
	private boolean solucion;		// TRUE = SI // FALSE = NO <-- si se pudo construir o no segun el programa a testear.
	private int fCasa; 				// fila menor de donde comienza la construcion de la casa.
	private int cCasa; 				// columna menor de donde comienza la construcion de la casa.
	private String orientacion;		// Orientacion de la puertita :)
	
	//lo de fila y columna menor lo dice el enunciado. 

	public Probador(File dirIn, File dirOut) throws FileNotFoundException {

		Scanner scIn   	 = new Scanner(dirIn); 
		Scanner scOut	 = new Scanner(dirOut);
		
		DX = scIn.nextInt();  
		DY = scIn.nextInt();
		
		terreno = new boolean[DX][DY]; // Matriz de peñascos	
		
		F = scIn.nextInt();  
		L = scIn.nextInt();  
		
		
		cantPeñasco = scIn.nextInt();

		for (int i = 0; i < cantPeñasco ; i++) {
			int tempFil = scIn.nextInt() - 1;		//  Bueno ya se sabe que una matriz
			int tempCol = scIn.nextInt() - 1; 	//  empieza a contar desde 0. 
		
			//	System.out.println(tempFil + " " + " " + tempCol );
		
			terreno[tempFil][tempCol] = true; // Si hay peñasco es TRUE.
		}

		scIn.close();

		String cadenaLoca = scOut.nextLine();
		System.out.println(cadenaLoca);
		if( cadenaLoca.equals("SI")) // si hay solucion saco estos datos:
		{
			solucion = true;  				//Use booleano porque usa menos memoria :v
			fCasa = scOut.nextInt() - 1;
			cCasa = scOut.nextInt() - 1;
			System.out.println(fCasa);
			System.out.println(cCasa);
			orientacion = scOut.nextLine(); //Orientacion que despues Braian va a confirmar :v
			System.out.println(orientacion);
			orientacion = scOut.nextLine(); //Orientacion que despues Braian va a confirmar :v
			System.out.println(orientacion);
			System.out.println(solucion);
		}
		else //no saco nada mas 
		{
			solucion  = false;
			System.out.println(solucion);

		}

		scOut.close();
	}
	
	public boolean probarFalso(){
		//si es norte/sur F corresponde al eje X
		// si es este/oeste F corresponde al eje Y
		try{
			if(orientacion.equals("N") || orientacion.equals("S")){
				
				// aca compruebo que la  casa entre
				for(int i = fCasa; i<(F+fCasa); i++){  //desde la fila minima hasta el fin del frente.
					for(int j = cCasa; j<(L+cCasa); j++){ //desde la columna minima hasta el fin de la profundidad.
						if (terreno[i][j])
							return false;  //Si en el terreno cuadrado de la casa hay un peñasco returno falso.
					}
				}

				
			}
			else if(orientacion.equals("E") || orientacion.equals("O")){

				// aca compruebo que la  casa entre	
				for(int i = fCasa; i<(F+fCasa); i++){  //desde la fila minima hasta el fin del frente.
					for(int j = cCasa; j<(L+cCasa); j++){ //desde la columna minima hasta el fin de la profundidad.
						if (terreno[j][i])
							return false;  //Si en el terreno cuadrado de la casa hay un peñasco returno falso.
					}
				}

			}
			
			return true; // si nunca devolvi falso significa que la casa entra
			
		}
		catch(ArrayIndexOutOfBoundsException e){  //Si en algun momento quedo fuera del terreno no cabe la casa
			return false;
		}		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	
		String miPathOut = "C:\\Users\\laboratorios.UNLMLAB\\Desktop\\Workspace\\Peñasco1\\PreparacionDePrueba\\LotePrueba\\Salida Esperada\\01.out";
		
		Probador p = new Probador(new File( "C:\\Datos\\01.in"),new File(miPathOut));
		

		if (  p.solucion )
			System.out.println("La solucion es : " + p.probarFalso() );
        
	}
}

