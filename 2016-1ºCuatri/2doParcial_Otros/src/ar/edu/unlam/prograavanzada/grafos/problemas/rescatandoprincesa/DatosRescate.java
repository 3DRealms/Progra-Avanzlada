package ar.edu.unlam.prograavanzada.grafos.problemas.rescatandoprincesa;

import java.util.ArrayList;
import java.util.List;

public class DatosRescate {

	private Integer cantClaros;
	private Integer cantSenderos;
	private Integer cantDragones;
	
	private Integer claroPrincesa;
	private Integer claroPrincipe;
	
	private List<Integer> clarosConDragones;
	
	private List<Sendero> senderos;

	public DatosRescate() {
		this.clarosConDragones = new ArrayList<Integer>();
		this.senderos = new ArrayList<Sendero>();
	}

	public Integer getCantClaros() {
		return cantClaros;
	}
	public void setCantClaros(Integer cantClaros) {
		this.cantClaros = cantClaros;
	}

	public Integer getCantSenderos() {
		return cantSenderos;
	}
	public void setCantSenderos(Integer cantSenderos) {
		this.cantSenderos = cantSenderos;
	}

	public Integer getCantDragones() {
		return cantDragones;
	}
	public void setCantDragones(Integer cantDragones) {
		this.cantDragones = cantDragones;
	}

	public Integer getClaroPrincesa() {
		return claroPrincesa;
	}
	public void setClaroPrincesa(Integer claroPrincesa) {
		this.claroPrincesa = claroPrincesa;
	}

	public Integer getClaroPrincipe() {
		return claroPrincipe;
	}
	public void setClaroPrincipe(Integer claroPrincipe) {
		this.claroPrincipe = claroPrincipe;
	}

	public List<Integer> getClarosConDragones() {
		return clarosConDragones;
	}
	public void setClarosConDragones(List<Integer> clarosConDragones) {
		this.clarosConDragones = clarosConDragones;
	}

	public List<Sendero> getSenderos() {
		return senderos;
	}
	public void setSenderos(List<Sendero> senderos) {
		this.senderos = senderos;
	}
	
}
