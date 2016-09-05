package funcion;

import java.io.*;

public class Resolver implements Expresion{
	
	private String []vector;
	private int cantVar;
	private int cantVal;
	private int [] valoresX;
	private int [] valoresY;
	private int [] valoresZ;
	private int cantEle;
	private int tope;
	private String [] resultados;
	private String [] expresion;
	private Expresion s1;
	
	public void Cargar(String ruta){

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			String[] datos;
			linea = br.readLine();
			datos=linea.split(" ");
			expresion= new String[datos.length];
			for(int i=0;i<datos.length;i++)
				expresion[i]=datos[i];
			linea=br.readLine();
			datos=linea.split(" ");
			cantVar=Integer.parseInt(datos[0]);
			cantVal=Integer.parseInt(datos[1]);
			resultados=new String[cantVal];
			
			if(cantVar==1)
			valoresX=new int[cantVal];
			if(cantVar==2)
			{valoresX=new int[cantVal];
			valoresY=new int[cantVal];
				
			}
			if(cantVar==3)
			{valoresX=new int[cantVal];
			valoresY=new int[cantVal];
			valoresZ=new int[cantVal];
				
			}
			if (cantVar!=0)
			for(int j=0;j<cantVal;j++)
			{  linea=br.readLine();
				datos=linea.split(" ");
				if(cantVar==1)
				valoresX[j]=Integer.parseInt(datos[0]);
				if(cantVar==2)
				{valoresX[j]=Integer.parseInt(datos[0]);
				valoresY[j]=Integer.parseInt(datos[1]);
					
				}
				if(cantVar==3)
				{valoresX[j]=Integer.parseInt(datos[0]);
				valoresY[j]=Integer.parseInt(datos[1]);
				valoresZ[j]=Integer.parseInt(datos[2]);
					
				}
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}}

	
	
	public double resolver(){  
        vector=new String[expresion.length];
        for(int k=0;k<cantVal;k++){
        cantEle=expresion.length;
        tope=-1;
        int i=0;
        
        while(cantEle!=0)
		{	
			
			switch(expresion[i])
			{case "+":
			{
			 
			 s1=new Suma(Double.parseDouble(vector[tope-1]),Double.parseDouble(vector[tope]));
			 vector[tope-1]=String.valueOf(s1.resolver());
			 tope=tope-1;
			 vector[tope+1]=null;
			 i++;
			 cantEle--;
			 break;}
			
			case "-":
			{
			 s1=new Resta(Double.parseDouble(vector[tope-1]),Double.parseDouble(vector[tope]));
			 vector[tope-1]=String.valueOf(s1.resolver());
			 tope=tope-1;
			 vector[tope+1]=null;
			 i++;
			 cantEle--; 
			  break;}
			
			case "*":
			{
			
			s1=new Multiplicacion(Double.parseDouble(vector[tope-1]),Double.parseDouble(vector[tope]));
			 vector[tope-1]=String.valueOf(s1.resolver());
			 
			 tope=tope-1;
			 vector[tope+1]=null;
			 i++;
			 cantEle--;
			   break;}
			
			case "/":
			{
				 s1=new Division(Double.parseDouble(vector[tope-1]),Double.parseDouble(vector[tope]));
				 vector[tope-1]=String.valueOf(s1.resolver());
				 tope=tope-1;
				 vector[tope+1]=null;
				 i++;
				 cantEle--; 
				  break;}
							
			case "^":
			{
				s1=new Potenciacion(Double.parseDouble(vector[tope-1]),Double.parseDouble(vector[tope]));
				 vector[tope-1]=String.valueOf(s1.resolver());
				 tope=tope-1;
				 vector[tope+1]=null;
				 i++;
				 cantEle--; 
				  break;}
			
			case "ln":
			{s1=new Logaritmo(Double.parseDouble(vector[tope]));
			 vector[tope]=String.valueOf(s1.resolver());
			 i++;
			 cantEle--;
			
			
			break;}
			
			case "x":
			 {  
				vector[tope+1]=String.valueOf(valoresX[k]);
				cantEle--;
				i++;
				tope++;
				break;
			}
			case "y":
			{
				vector[tope+1]=String.valueOf(valoresY[k]);
				cantEle--;
				i++;
				tope++;
				break;
			}
			case "z":
			{
				vector[tope+1]=String.valueOf(valoresZ[k]);
				cantEle--;
				i++;
				tope++;
				break;
			}
			
		    default:
		    	{s1= new Constante(Double.parseDouble(expresion[i]));
		    	 vector[tope+1]=String.valueOf(s1.resolver());
		    	 cantEle--;
		    	 i++;
		    	 tope++;
		    	break;
		    	}
			}
			
		}
	resultados[k]=(vector[0]);
}
		return cantEle;
		
}
	
	
	
	public void toFile(String file)  {
		FileWriter fw = null;
		PrintWriter out = null;

		try {
			fw = new FileWriter(file);
			out = new PrintWriter(fw);
			out.println(cantVal);
			for (int i = 0; i < cantVal; i++)
			out.println(resultados[i]);
		} catch (Exception e) {
			e.printStackTrace();
		
		
			
		}finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
