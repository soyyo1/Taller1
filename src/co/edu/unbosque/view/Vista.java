package co.edu.unbosque.view;

import java.awt.*;
import java.util.Scanner;

import javax.swing.*;
import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame {
	private Panelvista panel;
	private Scanner L;

	public Vista(Controller control) {
		/**
		 * En el metodo contructor se crea la ventana de la interfaz grafica, se
		 * instancia la clase panel que lleva los compentes de la ventana en este caso
		 * botones que se le asignaron a cada requerimiento de el taller
		 */
		setSize(500, 400);
		setResizable(false);
		setTitle("Taller 1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		panel = new Panelvista(control);
		add(panel, BorderLayout.CENTER);

	}

//	public int leerdato() {
//		int dato = L.nextInt();
////		L.nextLine();
//		return dato;
//	}

	/**
	 * Muestra un dato de tipo string con el uso de JOptioPane
	 * 
	 * @param dato
	 */
	public void mostrarResultados(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}

	/**
	 * El metodo pedirRequerimientoInicial genera un menu para seleccionar el requerimiento que desea realizar 
	 * 
	 * @return
	 */

	public String pedirRequerimientoInicial() {
		String dato = "";
		dato = JOptionPane.showInputDialog(null,
				"Ingrese el requerimiento que desea: \n 1) sumTotalSales \n 2) findByInvoiceNo \n 3) countByStockCode \n 4) avgMonthlySales \n 5) findPartiallyByDescription");
		return dato;
	}
	/**
	 * El metodo pedirRequerimiento2 pide el invoiceNo para realizar la busqueda para el
	 * requerimiento 3
	 * @return
	 */
	public String pedirRequerimiento2() {
		String dato = "";
		dato = JOptionPane.showInputDialog(null,
				"Ingrese el detalle de la factura que desea solicitar: ");
		return dato;
	}
	
	/**
	 * El metodo pedirRequerimiento3 pide el StockCode para la busqueda 
	 * @return
	 */
	public String pedirRequerimiento3() {
		String dato = "";
		dato = JOptionPane.showInputDialog(null,
				"Ingrese el stock del cual desea mostrar la cantidad de unidades vendidas: ");
		return dato;
	}
	
	public String pedirRequerimiento4() {
		String dato = "";
		dato = JOptionPane.showInputDialog(null,
				"Ingrese la descripción del producto que desea buscar: ");
		return dato;
	}
	/**
	 * El metodo pedirRequerimiento4MesInicial pide el requerimiento del mes inicial 
	 * @return
	 */
	public int pedirRequerimiento4MesInicial() {
		int numero = 0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes incial de busqueda: "));
		return numero;
	}
	/**
	 * El metodo pedirRequerimiento4MesFinal pide el requerimiento del mes final 
	 * @return
	 */
	public int pedirRequerimiento4MesFinal() {
		int numero = 0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes final de busqueda: "));
		return numero;
	}

	/**
	 * Pide un dato de tipo entero con el uso de JOptioPane
	 * 
	 * @return
	 */

	

}
