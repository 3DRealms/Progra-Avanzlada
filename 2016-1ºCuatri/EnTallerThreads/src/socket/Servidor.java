package socket;

import java.io.*;
import java.net.*;

public class Servidor {
	
	Servidor(){
		try{
			ServerSocket s = new ServerSocket(5000);
			for (int i=0; i< 10; i++){
				//Hasta que no pase le evento se queda bloqueado
				Socket c = s.accept();//
				//Flujo de Salida, Si hay Texto hay que recibir Texto
				DataOutputStream f = new DataOutputStream( c.getOutputStream());
				f.writeUTF("Hola Cliente Respuesta German"+(i+1));
				//Cierro la conexion
				c.close();
			}
		}
		catch (Exception e){
			
		}
	}

}
