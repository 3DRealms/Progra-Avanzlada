package viajando;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tren {

private int agresividad_tope;
private int cant_v;
private int agresividad_total;

public int getCant_v() {
	return cant_v;
}

public void setCant_v(int cant_v) {
	this.cant_v = cant_v;
}

public int getAgresividad_total() {
	return agresividad_total;
}

public void setAgresividad_total(int agresividad_total) {
	this.agresividad_total = agresividad_total;
}

public Tren(){
	this.agresividad_tope=0;
	this.agresividad_total=0;
	this.cant_v=0;
}

public Tren(int can,int agre,int at){
	this.cant_v=can;
	this.agresividad_tope=agre;
	this.agresividad_total=at;
}

public void escribir() throws IOException{
	FileWriter fw=new FileWriter("OUT/animales4.out");
	PrintWriter pr=new PrintWriter(fw);
	String linea=""+this.cant_v+" "+this.agresividad_total;
	pr.println(linea);
	pr.close();
}


	public static void main(String[] args) throws IOException {
		String path="IN/animales4.in";
		Zoologic zoo1=new Zoologic(path);
		Tren tren=new Tren();
		zoo1.calcularVagones(tren);
		tren.escribir();

	}

}
/*
terminar*/