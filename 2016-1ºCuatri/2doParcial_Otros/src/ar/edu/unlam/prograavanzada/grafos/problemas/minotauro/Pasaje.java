package ar.edu.unlam.prograavanzada.grafos.problemas.minotauro;

public class Pasaje {

	private Integer descansoDesde;
	private Integer descansoHasta;
	
	private Integer pasos;

	public Pasaje(Integer descansoDesde, Integer descansoHasta, Integer pasos) {
		this.descansoDesde = descansoDesde;
		this.descansoHasta = descansoHasta;
		this.pasos = pasos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Pasaje other = (Pasaje) obj;
		
		return ( descansoDesde.equals(other.descansoDesde) && descansoHasta.equals(other.descansoHasta) )
			|| ( descansoDesde.equals(other.descansoHasta) && descansoHasta.equals(other.descansoDesde) );
	}

	@Override
	public String toString() {
		return String.format("%d %d %d", this.descansoDesde, this.descansoHasta, this.pasos);
	}
	
}