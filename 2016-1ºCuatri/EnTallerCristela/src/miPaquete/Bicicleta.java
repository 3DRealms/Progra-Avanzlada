package miPaquete;

public class Bicicleta {
	private int idBicicleta;
	private double pesoSoportado;
	
	public boolean puedeLlevar (Paquete paquete, Empleado empleado){
		if (this.pesoSoportado > paquete.getPeso() && empleado.getHorasTrabajo() > paquete.getTiempoTransporte() )
			return true;
		return false;
	}
	
}
