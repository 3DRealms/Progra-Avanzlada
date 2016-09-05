package singletone;

//SINGLETON
public class HistorialAccesos {

	private int linea;
	private String registro;
	//Variable Estatica
	private static HistorialAccesos instance = new HistorialAccesos();
	
	//Usar Getter
	public static HistorialAccesos getInstance(){
		return instance;		
	}
	
	//Constructor privado
	private HistorialAccesos(){
		this.linea =1;
		this.registro= " ";
		}
	
	public void registrarEvento( String evento){
		this.registro += (linea++) + " " + evento +"\n ";
		System.out.println(this.registro);
		}	
}