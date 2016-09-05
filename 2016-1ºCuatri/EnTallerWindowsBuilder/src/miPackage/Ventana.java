package miPackage;

import javax.swing.*;

public class Ventana extends JFrame{
	
	private JLabel etiqueta;
	
	public Ventana(){
		setLayout(null);
		etiqueta = new JLabel ("Mi Etiqueta");
		//(UBICACION DOS PRIMEROS PARAMETROS, DIMENSIONES LOS OTROS 2)
		etiqueta.setBounds (128,95,161,14);
		add(etiqueta);
		setTitle("Ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,300);
		setVisible(true);
	}
	
	public static void main (String arg[]){
		
		new Ventana();
	}
	

}
