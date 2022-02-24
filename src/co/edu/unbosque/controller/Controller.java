package co.edu.unbosque.controller;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ECommerceData;
import co.edu.unbosque.model.persistence.EcommerceDataDAO;
import co.edu.unbosque.view.Vista;

public class Controller {
	private Vista vista;
	private ECommerceData ecommercedata;
	private EcommerceDataDAO ecommercedatadao;

	public Controller() {
		vista = new Vista(this);
		ecommercedatadao = new EcommerceDataDAO();

		iniciar();

	}
	/**
	 * El metodo iniciar se encarga llamar a todos los metodos para que funcionen siempre y cuando cumplan con un condicional 
	 */

	public void iniciar() {

		String dato = vista.pedirRequerimientoInicial();

		try {
			if (dato.equals("1")) {

				ecommercedatadao.sumTotalSales();

			} else if (dato.equals("2")) {

				String factura = vista.pedirRequerimiento2();

				ecommercedatadao.uploadData();

				ecommercedatadao.findByInvoiceNo(factura);

			} else if (dato.equals("3")) {

				String stock = vista.pedirRequerimiento3();

				vista.mostrarResultados(
						"La cantidad de unidades vendidas del stock es: " + ecommercedatadao.countByStockCode(stock));
			} else if (dato.equals("4")) {

				ecommercedatadao.avgMonthlySales();

			} else if (dato.equals("5")) {

				String descripcion = vista.pedirRequerimiento4();
				int fechaInicial = vista.pedirRequerimiento4MesInicial();
				int fechaFinal = vista.pedirRequerimiento4MesFinal();

				ecommercedatadao.uploadData();

				ecommercedatadao.findPartiallyByDescription(descripcion, fechaInicial, fechaFinal);

			} else if (dato != "1" || dato != "2" || dato != "3" || dato != "4" || dato != "5") {

				String mensaje = "Debe seleccionar entre un rango de 1 y 5";
				vista.mostrarResultados(mensaje);
			}

		} catch (Exception e) {
			String mensaje = "Ha sucedido un error";
			vista.mostrarResultados(mensaje);

		}
	}

}
