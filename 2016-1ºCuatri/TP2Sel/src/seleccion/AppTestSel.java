package seleccion;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class AppTestSel {

	public static void main(String[] args) {
		try {
			String [] lista = Lucas.listarIn(".in");
			for (int i=0; i < lista.length; i++){
				SEL sistema = new SEL(lista[i] + ".in");
				System.out.println(lista[i]);
				Calendar tIni= new GregorianCalendar();
				sistema.resolucionXgaussJordan();
				Calendar tFin= new GregorianCalendar();			
				Long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();			
				System.out.println("el tiempo que tarda en resolver es: " +diff);
				sistema.escribirArchivo(lista[i] + ".out");
			}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
