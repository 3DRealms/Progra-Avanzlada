package atendiendoEmergencia;
import java.util.*;

public class MatrizAdyacencia {
	

		private int matriz[][];
		private boolean Visto[];
		private int nodos;
		private boolean dirigido;
		
		
		public MatrizAdyacencia(int cant_nodos, boolean dirigido){
			
			this.nodos=cant_nodos;
			this.dirigido=dirigido;
			matriz=new int[nodos][nodos];
			Visto = new boolean[nodos];
			
			for(int i=0;i<nodos;i++){
				Visto[i]=false;
				for(int j=0;j<nodos;j++){
					matriz[i][j]=0;
				}
					
			}
				
				
		}
		
		public void agregarArista(int nodoA,int nodoB, int costo){
			
			matriz[nodoA-1][nodoB-1]=costo;
			if(!dirigido)
				matriz[nodoB-1][nodoA-1]=costo;
	
		}
		
		public int getCosto(int nodoA, int nodoB){
			return matriz[nodoA][nodoB];
		}
		
		public boolean sonAdyacentes(int nodoA, int nodoB){
			return matriz[nodoA][nodoB]!=0;
		}
		
		public Vector<Integer> getnodos(int nodoA){
			
			Vector<Integer> ady= new Vector <Integer>();
			
			for(int i=0;i<this.nodos;i++){
				if(i!=nodoA && matriz[nodoA][i]!=0 || matriz[i][nodoA]!=0)
					ady.add(i+1);
				}

			return ady;
		}
		
		public boolean adyacenciaNoVista(int v, int i) {
			if (v != i && matriz[v][i] != 0 && Visto[i] == false)
				return true;
			return false;
		}
		
		public boolean noEstanVistosTodos() {
			int cont = 0;
			for (int i = 0; i < nodos; i++)
				if (Visto[i] == true)
					cont++;
			if (cont == nodos)
				return false;
			return true;
		}

		public boolean noEstaVisto(int i) {
			return Visto[i]==false;
		}

		public void Visto(int i) {
			Visto[i]=true;
		}
		

}
