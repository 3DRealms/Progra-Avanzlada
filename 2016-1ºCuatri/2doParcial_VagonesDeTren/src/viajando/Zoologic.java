package viajando;
import java.io.*;
public class Zoologic {
private Especie[] especies;
private int tope_agresividad;

public Zoologic (String path) throws IOException{
	File archivo=new File(path);
	FileReader fr=new FileReader(archivo);
	BufferedReader br=new BufferedReader(fr);
	
	String linea=br.readLine();
	String[] dato;
	dato=linea.split(" ");
	
	especies=new Especie[Integer.parseInt(dato[0])];
	tope_agresividad=Integer.parseInt(dato[1]);
	String[] descripcion;
	for (int i = 0; i < Integer.parseInt(dato[0]); i++) {
		linea=br.readLine();
		descripcion=linea.split(" ");
		especies[i]=new Especie(descripcion[0],Integer.parseInt(descripcion[1]),Integer.parseInt(descripcion[2]));
		
			}
	this.ordenarMenosMas();
	br.close();
	fr.close();
	}


public Zoologic() {
	// TODO Auto-generated constructor stub
}


public Especie[] getEspecies() {
	return especies;
}


public void setEspecies(Especie[] especies) {
	this.especies = especies;
}


public int getTope_agresividad() {
	return tope_agresividad;
}


public void setTope_agresividad(int tope_agresividad) {
	this.tope_agresividad = tope_agresividad;
}


public void ordenarMenosMas(){
Zoologic aux=new Zoologic();
aux.setEspecies(this.especies);
aux.setTope_agresividad(this.tope_agresividad);

Especie nueva=new Especie("n",0,0);

for (int i = 0; i < especies.length; i++) {
	
	for ( int j = 0; j < especies.length-1; j++) {
	if(aux.especies[j].getAgresividad()>aux.especies[j+1].getAgresividad())
		{nueva=aux.especies[j];
		aux.especies[j]=aux.especies[j+1];
		aux.especies[j+1]=nueva;
		
		}
		
				}
			}
for (int i = 0; i < especies.length; i++) {
	this.especies[i]=aux.especies[i];
}

}


public void mostrar(){
	for (int i = 0; i < especies.length; i++) {
		System.out.println(this.especies[i].getNombre()+"  "+this.especies[i].getAgresividad());
	}
}

public int direfencia(int agr1,int agr2){
	int aux=agr1-agr2;
	if(aux<0)
		aux*=(-1);
	
	return aux;
}
public void calcularVagones(Tren tren){

int agresionTren=0;
int agresionAct=0;
int cantidad_vagones=0;
this.mostrar();

for (int i = 0; i < especies.length; i++) {
	int j=i;
	
	while(j<this.especies.length&&
		this.direfencia(this.especies[i].getAgresividad(), this.especies[j].getAgresividad())<=this.tope_agresividad&&
		agresionAct<=this.tope_agresividad){
		j++;
	}
	if(j>=this.especies.length){
		System.out.println("vagon desde "+this.especies[i].getNombre()+" hasta "+this.especies[j-1].getNombre());
		agresionAct+=this.direfencia(this.especies[i].getAgresividad(), this.especies[j-1].getAgresividad());
		cantidad_vagones++;
		i=j;
	}
	else{
		if(this.direfencia(this.especies[i].getAgresividad(), this.especies[j].getAgresividad())<=this.tope_agresividad){
			agresionAct+=this.direfencia(this.especies[i].getAgresividad(), this.especies[j].getAgresividad());
			cantidad_vagones++;
			i=j;
			System.out.println("vagon desde "+this.especies[i].getNombre()+" hasta "+this.especies[j].getNombre());
		}
		else{
			System.out.println("vagon desde "+this.especies[i].getNombre()+" hasta "+this.especies[j-1].getNombre());
				agresionAct+=this.direfencia(this.especies[i].getAgresividad(), this.especies[j-1].getAgresividad());
				cantidad_vagones++;
				i=j-1;
		}
	}
	
	
}

tren.setAgresividad_total(agresionAct);
tren.setCant_v(cantidad_vagones);
}


}