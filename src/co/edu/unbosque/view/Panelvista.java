package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.controller.Controller;

public class Panelvista extends JLabel{
	private JButton butsumTotalSales;
	private JButton butfindByInvoiceNo;
	private JButton butcountByStockCode;
	private JButton butavgMonthlySales;
	private JButton butfindPartiallyByDescription;
	public static final String TOTAL = "Total Ventas";
	public static final String REGISTROS = "Lista registros";
	public static final String STOCK = "unidades vendidas por stock";
	public static final String PROMEDIO = "Promedio Ventas Mensuales";
	public static final String BUSQUEDA = "Busqueda";

	public Panelvista (Controller control) {
		setLayout(new GridLayout (4,4));
		TitledBorder border = BorderFactory.createTitledBorder("")	;
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		inicializarComponentes(control);
	}
	
	public void inicializarComponentes (Controller control) {
		butsumTotalSales = new JButton("Total Ventas");
		butfindByInvoiceNo = new JButton("Lista registros");
		butcountByStockCode = new JButton("unidades vendidas por stock");
		butavgMonthlySales = new JButton("Promedio Ventas Mensuales");
		butfindPartiallyByDescription = new JButton("Busqueda");
		add(butsumTotalSales);
		add(butfindByInvoiceNo);
		add(butcountByStockCode);
		add(butavgMonthlySales);
		add(butfindPartiallyByDescription);
	}

	public JButton getButsumTotalSales() {
		return butsumTotalSales;
	}

	public void setButsumTotalSales(JButton butsumTotalSales) {
		this.butsumTotalSales = butsumTotalSales;
	}

	public JButton getButfindByInvoiceNo() {
		return butfindByInvoiceNo;
	}

	public void setButfindByInvoiceNo(JButton butfindByInvoiceNo) {
		this.butfindByInvoiceNo = butfindByInvoiceNo;
	}

	public JButton getButcountByStockCode() {
		return butcountByStockCode;
	}

	public void setButcountByStockCode(JButton butcountByStockCode) {
		this.butcountByStockCode = butcountByStockCode;
	}

	public JButton getButavgMonthlySales() {
		return butavgMonthlySales;
	}

	public void setButavgMonthlySales(JButton butavgMonthlySales) {
		this.butavgMonthlySales = butavgMonthlySales;
	}

	public JButton getButfindPartiallyByDescription() {
		return butfindPartiallyByDescription;
	}

	public void setButfindPartiallyByDescription(JButton butfindPartiallyByDescription) {
		this.butfindPartiallyByDescription = butfindPartiallyByDescription;
	}

	public static String getTotal() {
		return TOTAL;
	}

	public static String getRegistros() {
		return REGISTROS;
	}

	public static String getStock() {
		return STOCK;
	}

	public static String getPromedio() {
		return PROMEDIO;
	}

	public static String getBusqueda() {
		return BUSQUEDA;
	}


}
