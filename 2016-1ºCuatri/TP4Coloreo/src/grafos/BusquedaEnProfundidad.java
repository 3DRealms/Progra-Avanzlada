package grafos;

public class BusquedaEnProfundidad {
	private boolean[] marcado;
	private int count;

	public BusquedaEnProfundidad(Grafo g, int s) {
		marcado = new boolean[g.getCantidadNodos()];
		dfs(g, s);
	}

	private void dfs(Grafo grafo, int v) {
		count++;
		marcado[v] = true;
		for (int w : grafo.nodosAdyacentesA(v)) {
			if (!marcado[w]) {
				dfs(grafo, w);
			}
		}
	}

	public boolean marcado(int v) {
		return marcado[v];
	}
}
