package co.edu.unbosque.controller;
import java.io.File;

import co.edu.unbosque.model.ECommerceData;
import co.edu.unbosque.model.persistence.EcommerceDataDAO;

public class AplMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EcommerceDataDAO eCommerceDataDAO = new EcommerceDataDAO();
		ECommerceData eCommerceData = new ECommerceData();
		
		eCommerceDataDAO.uploadData();
//		leerCSV.prueba();

		
		
	}

}
