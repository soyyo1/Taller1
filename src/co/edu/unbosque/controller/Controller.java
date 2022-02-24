package co.edu.unbosque.controller;

import co.edu.unbosque.model.ECommerceData;
import co.edu.unbosque.model.persistence.EcommerceDataDAO;
import co.edu.unbosque.view.Vista;

public class Controller {
	private Vista vista;
	private ECommerceData ecommercedata;
	private EcommerceDataDAO ecommercedatadao;

	public Controller() {
		vista = new Vista(this);
//		 ecommercedata = new ECommerceData();
		ecommercedatadao = new EcommerceDataDAO();
//		 vista.setVisible(true);

		iniciar();

	}

	public void iniciar() {

		vista.pedirRequerimientoInicial();

		if (vista.pedirRequerimientoInicial().equals("1")) {

			ecommercedatadao.sumTotalSales();

		} else if (vista.pedirRequerimientoInicial().equals("2")) {

			String factura = vista.pedirRequerimiento2();

			ecommercedatadao.uploadData();

			ecommercedatadao.findByInvoiceNo(factura);

		} else if (vista.pedirRequerimientoInicial().equals("3")) {

			String stock = vista.pedirRequerimiento3();

			vista.mostrarResultados(
					"La cantidad de unidades vendidas del stock es: " + ecommercedatadao.countByStockCode(stock));
		} else if (vista.pedirRequerimientoInicial().equals("4")) {

			ecommercedatadao.avgMonthlySales();

		} else if (vista.pedirRequerimientoInicial().equals("5")) {

			String descripcion = vista.pedirRequerimiento4();
			int fechaInicial = vista.pedirRequerimiento4MesInicial();
			int fechaFinal = vista.pedirRequerimiento4MesFinal();

			ecommercedatadao.uploadData();

			ecommercedatadao.findPartiallyByDescription(descripcion, fechaInicial, fechaFinal);
			
		}

	}

}
