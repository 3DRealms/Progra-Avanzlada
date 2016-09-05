package alta_en_el_cielo;
import java.io.*;
import java.util.*;

public class Bandera {
	private int largo;
	private int escuela;
	private int costuras;
	public Bandera(int l, int e){
		largo=l;
		escuela=e;
		costuras =0;
	}
	
	
	public int getCosturas() {
		return costuras;
	}


	public void setCosturas(int costuras) {
		this.costuras = costuras;
	}


	public double getLargo() {
		return largo;
	}


	public void setLargo(int largo) {
		this.largo = largo;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File archivo=null;
		FileReader fr=null;
		BufferedReader br=null;
		
		archivo=new File("bandera.txt");
		
			try {
				fr= new FileReader(archivo);
				br= new BufferedReader(fr);
				
				String linea= br.readLine();
				String datos[]=linea.split(" ");
				
				double carretel = Double.parseDouble(datos[0]);
				int cant_escuelas = Integer.parseInt(datos[1]);
				
				ArrayList <Bandera> escuelas = new ArrayList<Bandera>();
				
				int i=0;
				while(i<cant_escuelas){
					
				linea = br.readLine();
				Bandera retazos = new Bandera(Integer.parseInt(linea),i+1);
				escuelas.add(retazos);
				i++;
				
				}
				
				int j=0;
				
				while(carretel>=escuelas.get(j).largo){

					         while(j< escuelas.size() && carretel>=escuelas.get(j).largo){
				    		carretel-=escuelas.get(j).largo;
				    		 escuelas.get(j).setCosturas(escuelas.get(j).costuras+1);
				    		//obtener el nuevo largo modificando el objeto 
					        j++;
					         }
						j=0;
					}		
				
					
				System.out.println(escuelas.get(0).costuras);
				System.out.println(carretel);
				
				
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

}
	
}
