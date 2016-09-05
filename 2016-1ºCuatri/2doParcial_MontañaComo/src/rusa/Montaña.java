package rusa;
import java.io.*;

public class Montaña {
private int cant_mv;
private int[] alturas;
private int altura_salida;
private Carrito carrito;


public Montaña(String path) throws IOException{
	File archivo=new File(path);
	FileReader fr=new FileReader(archivo);
	BufferedReader br =new BufferedReader(fr);
	
	String linea= br.readLine();
	cant_mv=Integer.parseInt(linea);
	this.alturas=new int[cant_mv];
	for (int i = 0; i<cant_mv  ; i++) {
		linea=br.readLine();
		this.alturas[i]=Integer.parseInt(linea);
	}
	linea=br.readLine();
	this.altura_salida=this.alturas[0]-Integer.parseInt(linea);
	this.carrito=new Carrito(this.altura_salida);
	
	this.alturas[0]=this.altura_salida;
}

public int distancia(){
	int distancia=0;
	int aux=0;
	int bandera=0;
	int i=0;
	while(i<alturas.length-1&&bandera>=0) {
		aux=this.alturas[i]-this.alturas[i+1];
		if(aux>=0){
			distancia+=aux;
			this.disminuirVelocidad();
			System.out.println("estoy sumando aux");
			i++;
		}
		if(aux<0){
			aux=aux*(-1);
			if(aux<this.carrito.getVelocidad())
				{distancia+=aux;
				i++;
				}
			else
				{distancia+=this.carrito.getVelocidad();
				bandera=-1;
				System.out.println("estoy sumando velocidad");
				}
		}
	}
	
	return distancia;
}
public void disminuirVelocidad(){
	int velocidadActual=this.carrito.getVelocidad();
	this.carrito.setVelocidad(velocidadActual-1);
}

public void escribirArchivo(int distancia) throws IOException{
	FileWriter fw=new FileWriter("OUT/SALIDA.OUT");
	PrintWriter pw=new PrintWriter(fw);
	String linea=""+distancia+" "+this.carrito.getVelocidad();
	pw.println(linea);
	pw.close();
	fw.close();
	
}

	public static void main(String[] args) throws IOException {
		String path=("IN/ENTRADA.IN");
		Montaña prueba=new Montaña(path);
		int distancia=prueba.distancia();
		prueba.escribirArchivo(distancia);

	}

}
