package ar.edu.unlam.prograavanzada.grafos;

import ar.edu.unlam.prograavanzada.grafos.algoritmos.Prim;
import ar.edu.unlam.prograavanzada.grafos.entidades.Arista;
import ar.edu.unlam.prograavanzada.grafos.entidades.Grafo;
import ar.edu.unlam.prograavanzada.grafos.problemas.acortandoelcamino.AcortandoElCamino;
import ar.edu.unlam.prograavanzada.grafos.problemas.arbol.Arbol;
import ar.edu.unlam.prograavanzada.grafos.problemas.casaderegalos.CasasDeRegalos;
import ar.edu.unlam.prograavanzada.grafos.problemas.conexionesenred.ConexionesEnRed;
import ar.edu.unlam.prograavanzada.grafos.problemas.gusano.Gusano;
import ar.edu.unlam.prograavanzada.grafos.problemas.invitadoscasamiento.InvitadosCasamiento;
import ar.edu.unlam.prograavanzada.grafos.problemas.rescatandoprincesa.RescatandoALaPrincesa;
import ar.edu.unlam.prograavanzada.grafos.problemas.vecinos.Vecinos;
import ar.edu.unlam.prograavanzada.grafos.problemas.minotauro.Minotauro;


@SuppressWarnings("unused")
public class Main {

	private static final String carpetaArchivos = "problemas/archivos/";
	
	public static void main(String[] args) throws Exception {
//		casamiento();
//		gusano();
//		acortandoElCamino();
//		casaDeRegalos();
		rescatandoALaPrincesa();
//		arbol();
//		conexionesEnRed();
//		minoTauro();
		//No anda
		//vecinos();
	}

	private static void vecinos() throws Exception {
		Vecinos vecinos = new Vecinos(carpetaArchivos+"minotauro.in");
		vecinos.resolver();
		vecinos.grabar(carpetaArchivos+"minotauro.out");
	}
	
	private static void minoTauro() throws Exception {
		Minotauro minotauro = new Minotauro(carpetaArchivos+"minotauro.in");
		minotauro.resolver();
		minotauro.grabar(carpetaArchivos+"minotauro.out");
	}
	
	private static void casamiento() {
		InvitadosCasamiento casamiento = new InvitadosCasamiento(carpetaArchivos+"casamiento.in");
		casamiento.resolver();
		casamiento.grabar(carpetaArchivos+"casamiento.out");
	}

	private static void gusano() {
		Gusano gusano = new Gusano(carpetaArchivos+"gusano.in");
		gusano.resolver();
		gusano.grabarResultado(carpetaArchivos+"gusano.out");
	}

	private static void acortandoElCamino() {
		AcortandoElCamino acortandoElCamino = new AcortandoElCamino(carpetaArchivos+"ciudad.in");
		acortandoElCamino.resolver();
	}

	private static void casaDeRegalos(){
		CasasDeRegalos casaDeRegalos = new CasasDeRegalos(carpetaArchivos+"regalos.in");
		casaDeRegalos.resolver();
		casaDeRegalos.grabarResultado(carpetaArchivos+"regalos.out");
	}
	private static void rescatandoALaPrincesa() {
		RescatandoALaPrincesa rescatandoALaPrincesa = new RescatandoALaPrincesa(carpetaArchivos+"princesa.ok.in");
		rescatandoALaPrincesa.resolver();
		rescatandoALaPrincesa.grabarResultado(carpetaArchivos+"princesa.out");
	}

	private static void testGenerador() throws Exception {
		Grafo g = new Grafo(20);
		g.generarPorProbabilidadDeAristas(50);
		g.grabarArchivo(carpetaArchivos+"grafo.probaristas.out");
		
		g = new Grafo(20);
		g.generarPorPorcentajeDeAdyacencia(25);
		g.grabarArchivo(carpetaArchivos+"grafo.porcadyacencia.out");
		
		g = new Grafo(20);
		g.generarRegularPorGrado(2);
		g.grabarArchivo(carpetaArchivos+"grafo.regularporgrado.out");
		
		g = new Grafo(20);
		g.generarRegularNPartito(4);;
		g.grabarArchivo(carpetaArchivos+"grafo.regularnpartito.out");
	}
	
	private static void pruebaPrim() {
		Integer[][] matrizPrueba = new Integer[7][7];
		
		matrizPrueba[0][1]=7;
		matrizPrueba[0][3]=5;
		
		matrizPrueba[1][0]=7;
		matrizPrueba[1][2]=8;
		matrizPrueba[1][3]=9;
		matrizPrueba[1][4]=7;
		
		matrizPrueba[2][1]=8;
		matrizPrueba[2][4]=5;
		
		matrizPrueba[3][0]=5;
		matrizPrueba[3][1]=9;
		matrizPrueba[3][4]=15;
		matrizPrueba[3][5]=6;
		
		matrizPrueba[4][1]=7;
		matrizPrueba[4][2]=5;
		matrizPrueba[4][3]=15;
		matrizPrueba[4][5]=8;
		matrizPrueba[4][6]=9;
		
		matrizPrueba[5][3]=6;
		matrizPrueba[5][4]=8;
		matrizPrueba[5][6]=11;
		
		matrizPrueba[6][4]=9;
		matrizPrueba[6][5]=11;
		
		Prim prim = new Prim(matrizPrueba);
		prim.resolver();
		
		Integer peso=0;
		for(Arista arista : prim.getArbolMenorCosto()){
			System.out.println(arista);
			peso+=arista.getPeso();
		}
		System.out.println("Peso arbol: "+peso);
		
	}

	private static void conexionesEnRed(){
		ConexionesEnRed conexionesEnRed = new ConexionesEnRed(carpetaArchivos+"conectar.in");
		conexionesEnRed.resolver();
		conexionesEnRed.grabar(carpetaArchivos+"conectar.out");
	}
	
	private static void arbol(){
		Arbol arbol = new Arbol(carpetaArchivos+"arbol.in");
		arbol.resolver();
		arbol.grabarResultado(carpetaArchivos+"arbol.out");
	}
}
