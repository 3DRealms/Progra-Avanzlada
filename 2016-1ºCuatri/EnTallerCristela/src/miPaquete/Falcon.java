package miPaquete;

public class Falcon {
	private int idFalcon;
	private double pesoSoportado;
	public int getIdFalcon() {
		return idFalcon;
	}
	
	public void setIdFalcon(int idFalcon) {
		this.idFalcon = idFalcon;
	}
	
	public double getPesoSoportado() {
		return pesoSoportado;
	}
	
	public void setPesoSoportado(double pesoSoportado) {
		this.pesoSoportado = pesoSoportado;
	}
	
	public boolean puedeLlevar (Paquete paquete, Empleado empleado){
		if (this.pesoSoportado > paquete.getPeso() && empleado.getHorasTrabajo() > paquete.getTiempoTransporte() )
			return true;
		return false;
	}

}
