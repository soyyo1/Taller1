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
		 ecommercedatadao= new EcommerceDataDAO();
//		 vista.setVisible(true);
		
	 }
	 
}
