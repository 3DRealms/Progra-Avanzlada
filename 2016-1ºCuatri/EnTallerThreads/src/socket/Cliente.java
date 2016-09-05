package socket;

import java.io.*;
import java.net.*;

public class Cliente {
	Cliente(){
		try{
			Socket c = new Socket ("10.5.192.169",5000);
			DataInputStream f = new DataInputStream( c.getInputStream());
			System.out.println(f.readUTF());
			c.close();
		}
		catch(Exception e){
			
		}
	}

}
