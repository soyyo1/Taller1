package co.edu.unbosque.view;

import java.awt.*;
import java.util.Scanner;

import javax.swing.*;
import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame{
private Panelvista  panel;
private Scanner L;

	public Vista(Controller control) {
		/**
		 * En el metodo contructor se crea la ventana de la interfaz grafica, se instancia la clase panel 
		 * que lleva los compentes de la ventana en este caso botones que se le asignaron a cada requerimiento
		 * de el taller 
		 */
		setSize(500,400);
		setResizable(false);
		setTitle("Taller 1");
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    setLayout(new BorderLayout());
	    panel = new Panelvista(control);
	    add(panel,BorderLayout.CENTER);
	    
	}
	public int  leerdato() {
		int dato = L.nextInt();
//		L.nextLine();
		return dato;
	}
	/**
	 * Muestra un dato de tipo string con el uso de JOptioPane
	 * @param dato
	 */
	public void mostrarResultados(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}
	/**
	 *  Pide un dato de tipo string con el uso de JOptioPane
	 * @return
	 */
	
	public String pedirDato() {
		String dato = "";
		dato = JOptionPane.showInputDialog(null, "Entre Dato:");
		return dato;
	}
	/**
	 *  Pide un dato de tipo entero con el uso de JOptioPane
	 * @return
	 */
	
	public int pedirDatoEntero() {
		int numero = 0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre Nùmero:"));
		return numero;
	}
	
	/**
	 * Se generan los getters y setters
	 * 
	 */
	public Panelvista getPanel() {
		return panel;
	}
	public void setPanel(Panelvista panel) {
		this.panel = panel;
	}
	
}
