package calles.casosrunner;

import calles.resolucion.CallesRunner;

public class CasosRunner {

	public static void main(String[] args) {
		String[][] paths = {
				{"INOUT\\00_casoDelEnunciado.in","INOUT\\00_casoDelEnunciado.out"},
				{"INOUT\\01_minimaCantidadDeEsquinas.in","INOUT\\01_minimaCantidadDeEsquinas.out"},
				{"INOUT\\02_noHayCamino.in","INOUT\\02_noHayCamino.out"},
				{"INOUT\\03_todosIgualPeso.in","INOUT\\03_todosIgualPeso.out"},
				{"INOUT\\04_caminoLargoCostoChico.in","INOUT\\04_caminoLargoCostoChico.out"},
				{"INOUT\\05_noCombieneInvertir.in","INOUT\\05_noCombieneInvertir.out"},
				{"INOUT\\06_unicoCamino.in","INOUT\\06_unicoCamino.out"},
				{"INOUT\\07_noEsPosibleInvertir.in","INOUT\\07_noEsPosibleInvertir.out"},
				{"INOUT\\08_pruebaDeEstres.in","INOUT\\08_pruebaDeEstres.out"},
};


		String[] path = paths[0];
		CallesRunner.main(path);
		
		String[] path1 = paths[1];
		CallesRunner.main(path1);
		
		String[] path2 = paths[2];
		CallesRunner.main(path2);
		
		String[] path3 = paths[3];
		CallesRunner.main(path3);
		
		String[] path4 = paths[4];
		CallesRunner.main(path4);
		
		String[] path5 = paths[5];
		CallesRunner.main(path5);
		
		String[] path6 = paths[6];
		CallesRunner.main(path6);
		
		String[] path7 = paths[7];
		CallesRunner.main(path7);
		
		String[] path8 = paths[8];
		CallesRunner.main(path8);

/*		String[][] paths = {
				{"INOUTPROFE\\caso00.in","INOUTPROFE\\caso00.out"},
				{"INOUTPROFE\\caso01.in","INOUTPROFE\\caso01.out"},
				{"INOUTPROFE\\caso02.in","INOUTPROFE\\caso02.out"},
				{"INOUTPROFE\\caso03.in","INOUTPROFE\\caso03.out"},
				{"INOUTPROFE\\caso04.in","INOUTPROFE\\caso04.out"},
				{"INOUTPROFE\\caso05.in","INOUTPROFE\\caso05.out"},
				
};

		String[] path = paths[0];
		CallesRunner.main(path);
		
		String[] path1 = paths[1];
		CallesRunner.main(path1);
		
		String[] path2 = paths[2];
		CallesRunner.main(path2);
		
		String[] path3 = paths[3];
		CallesRunner.main(path3);
		
		String[] path4 = paths[4];
		CallesRunner.main(path4);
		
		String[] path5 = paths[5];
		CallesRunner.main(path5);
		
		String[] path6 = paths[6];
		CallesRunner.main(path6);
		
		
	*/	
	}

}