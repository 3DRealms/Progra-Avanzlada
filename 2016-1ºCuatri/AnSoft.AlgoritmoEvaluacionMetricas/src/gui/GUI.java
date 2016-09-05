package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import evaluacion.Categorias;
import evaluacion.Evaluaciones;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class GUI extends JFrame {

	private static final long serialVersionUID = 8375595066259798834L;
	private static GUI frame;
	private JPanel contentPane;
	private JLabel lblCategoria;
	private JLabel lblDescripcion;
	private HashMap<Categorias, Evaluaciones> categorias;
	private int indexCategorias;
	private Categorias categoriaActual;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				confirmarSalir();
			}
		});
		setTitle("Algoritmo de Evaluaci\u00F3n de Calidad (Grupo 11)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCategoria = new JLabel("");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(20, 11, 229, 30);
		contentPane.add(lblCategoria);
		
		JRadioButton rdbtnBueno = new JRadioButton("Bueno");
		buttonGroup.add(rdbtnBueno);
		rdbtnBueno.setBounds(20, 74, 109, 23);
		contentPane.add(rdbtnBueno);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		buttonGroup.add(rdbtnRegular);
		rdbtnRegular.setBounds(20, 114, 109, 23);
		contentPane.add(rdbtnRegular);
		
		JRadioButton rdbtnMalo = new JRadioButton("Malo");
		buttonGroup.add(rdbtnMalo);
		rdbtnMalo.setBounds(20, 155, 109, 23);
		contentPane.add(rdbtnMalo);
		
		lblDescripcion = new JLabel("");
		lblDescripcion.setBounds(177, 78, 207, 150);
		contentPane.add(lblDescripcion);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBueno.isSelected()) {
					categorias.put(categoriaActual, Evaluaciones.BUENA);
				}
				else if(rdbtnRegular.isSelected()) {
					categorias.put(categoriaActual, Evaluaciones.REGULAR);
				}
				else if(rdbtnMalo.isSelected()) {
					categorias.put(categoriaActual, Evaluaciones.MALA);
				}
				else {
					//ERROR, seleccione una evaluacion
					return;
				}
				if(indexCategorias < Categorias.values().length) {
					indexCategorias++;
					categoriaActual = Categorias.values()[indexCategorias];
					lblCategoria.setText(categoriaActual.getNombre());
					lblDescripcion.setText(categoriaActual.getDescripcion());
				}
			}
		});
		btnSiguiente.setBounds(20, 205, 89, 23);
		contentPane.add(btnSiguiente);
		
		categorias = new HashMap<Categorias, Evaluaciones>();
		for(Categorias c : Categorias.values()) {
			categorias.put(c, null);
		}
		indexCategorias = 0;
		categoriaActual = Categorias.values()[indexCategorias];
		lblCategoria.setText(categoriaActual.getNombre());
		lblDescripcion.setText(categoriaActual.getDescripcion());
	}
	
	private void confirmarSalir() {
		int option = JOptionPane.showConfirmDialog(frame, "Esta seguro que quiere salir?",
													"Cerrando aplicacion", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION) {
			frame.dispose();
		}
	}
}
