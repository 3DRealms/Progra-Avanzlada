import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppTest {
	
	public static void main(String[] args) {
	new AppTest().grabar("Parcial.txt");
	}
	
	public void grabar(String path) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			for (int i = 1; i <= 40; i++){
				pw.println(i+" A[] B[] C[] D[] E[] SEGURO[]");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
				try {
					fw.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}