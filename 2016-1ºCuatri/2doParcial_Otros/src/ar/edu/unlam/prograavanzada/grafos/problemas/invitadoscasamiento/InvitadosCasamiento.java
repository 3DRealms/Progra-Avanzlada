package ar.edu.unlam.prograavanzada.grafos.problemas.invitadoscasamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvitadosCasamiento {

	private Integer cantidadInvitados;
	private List<NodoEnemigo> nodosEnemigos;
	private Integer[][] matrizEnemistad;
	private Integer maximoInvitados;
	
	public InvitadosCasamiento(final String archivoEntrada){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(new File(archivoEntrada));
			br = new BufferedReader(fr);
			
			String[] linea = br.readLine().split(" ");
			this.cantidadInvitados = Integer.valueOf(linea[0]);
			Integer cantidadEnemistades = Integer.valueOf(linea[1]);
			
			this.nodosEnemigos = new ArrayList<NodoEnemigo>();
			this.matrizEnemistad = new Integer[this.cantidadInvitados][this.cantidadInvitados];
			
			for(int i=0; i<cantidadEnemistades; i++){
				linea = br.readLine().split(" ");
				
				Integer nroInvitadoConEnemigo1 = Integer.valueOf(linea[0])-1;
				Integer nroInvitadoConEnemigo2 = Integer.valueOf(linea[1])-1;
				
				NodoEnemigo nodo1 = new NodoEnemigo(nroInvitadoConEnemigo1);
				if(!this.nodosEnemigos.contains(nodo1)){
					this.nodosEnemigos.add(nodo1);
				}
				this.nodosEnemigos.get(this.nodosEnemigos.indexOf(nodo1)).incrementarGrado();
				
				NodoEnemigo nodo2 = new NodoEnemigo(nroInvitadoConEnemigo2);
				if(!this.nodosEnemigos.contains(nodo2)){
					this.nodosEnemigos.add(nodo2);
				}
				this.nodosEnemigos.get(this.nodosEnemigos.indexOf(nodo2)).incrementarGrado();
				
				this.matrizEnemistad[nroInvitadoConEnemigo1][nroInvitadoConEnemigo2]=1;
				this.matrizEnemistad[nroInvitadoConEnemigo2][nroInvitadoConEnemigo1]=1;
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void resolver(){
		this.maximoInvitados = this.cantidadInvitados
				-this.nodosEnemigos.size()
				+this.obtenerCantidadMayorColor();
	}

	private Integer obtenerCantidadMayorColor() {
		Collections.sort(this.nodosEnemigos);
		
		Integer colorActual=0, nodosColoreados=0, cantMayorColor=0,
				cantidadEnemigos=this.nodosEnemigos.size();
		
		while(nodosColoreados<cantidadEnemigos){
			colorActual++;
			Integer cantidadColorActual=0;
			
			for(Integer indice=0; indice<cantidadEnemigos && nodosColoreados<cantidadEnemigos; indice++){
				if(this.nodosEnemigos.get(indice).getColor()==0 && puedeColorear(indice, colorActual)){
					this.nodosEnemigos.get(indice).setColor(colorActual);
					nodosColoreados++;
					cantidadColorActual++;
				}
			}
			if(cantMayorColor<cantidadColorActual)
				cantMayorColor=cantidadColorActual;
		}
		return cantMayorColor;
	}

	private Boolean puedeColorear(Integer indice, Integer colorActual) {
		Integer nroInvitado = this.nodosEnemigos.get(indice).getNroInvitado();
		for(Integer i=0; i<this.nodosEnemigos.size(); i++){
			if(this.matrizEnemistad[nroInvitado][this.nodosEnemigos.get(i).getNroInvitado()]!=null
					&& this.nodosEnemigos.get(i).getColor()==colorActual){
				return false;
			}
		}
		return true;
	}
	
	public void grabar(final String archivoSalida){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(new File(archivoSalida));
			pw = new PrintWriter(fw);
			pw.println(this.maximoInvitados);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pw!=null)
					pw.close();
				if(fw!=null)
					fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	}
	
}
