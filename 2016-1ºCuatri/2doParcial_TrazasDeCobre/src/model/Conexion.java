package model;

public class Conexion {
	private int led;
	private int control;
	
	public Conexion(int led, int control) {
		this.led = led;
		this.control = control;
	}

	@Override
	public String toString() {
		return control + " " + led;
	}

	public int getLed() {
		return led;
	}

	public void setLed(int led) {
		this.led = led;
	}

	public int getControl() {
		return control;
	}

	public void setControl(int control) {
		this.control = control;
	}
	
}
