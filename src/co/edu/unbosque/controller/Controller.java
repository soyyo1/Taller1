package co.edu.unbosque.controller;

import co.edu.unbosque.model.ECommerceData;
import co.edu.unbosque.view.Vista;

public class Controller {
	private Vista vista;
	 private ECommerceData ecommercedata;
	 public Controller() {
		 vista = new Vista(this);
		 ecommercedata = new ECommerceData();
		 vista.setVisible(true);
	 }
	 
}
