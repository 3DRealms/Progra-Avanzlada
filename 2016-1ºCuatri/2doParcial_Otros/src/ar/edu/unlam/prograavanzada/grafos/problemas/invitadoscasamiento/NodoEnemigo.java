package ar.edu.unlam.prograavanzada.grafos.problemas.invitadoscasamiento;

public class NodoEnemigo implements Comparable<NodoEnemigo> {

	private Integer nroInvitado;
	private Integer grado;
	private Integer color;

	public NodoEnemigo(Integer nroInvitado) {
		this.nroInvitado = nroInvitado;
		this.grado = 0;
		this.color = 0;
	}

	public Integer getNroInvitado() {
		return nroInvitado;
	}
	public Integer getGrado() {
		return grado;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getColor() {
		return color;
	}
	
	public void incrementarGrado(){
		this.grado++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nroInvitado == null) ? 0 : nroInvitado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodoEnemigo other = (NodoEnemigo) obj;
		if (nroInvitado == null) {
			if (other.nroInvitado != null)
				return false;
		} else if (!nroInvitado.equals(other.nroInvitado))
			return false;
		return true;
	}

	@Override
	public int compareTo(NodoEnemigo o) {
		return this.getGrado()-o.getGrado();
	}
	
}
