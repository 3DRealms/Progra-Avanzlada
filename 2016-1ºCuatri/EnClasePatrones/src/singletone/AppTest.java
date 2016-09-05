package singletone;

public class AppTest {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			HistorialAccesos.getInstance().registrarEvento("jose");
			HistorialAccesos.getInstance().registrarEvento("sasa");
			HistorialAccesos.getInstance().registrarEvento("pepe");
	}
}
