package co.edu.unbosque.model;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.LeerCSV;

public class ECommerceData {

//	final String PROPERTIES_FILE = "D:/WORKSPACE/src/co/edu/unbosque/data.csv";

	private String invoiceNo;
	private String stockCode;
	private String description;
	private int quantity;
	private Date invoiceDate;
	private float unitPrice;
	private String customerID;
	private String country;

	private LeerCSV leerCSV;

	private ArrayList<ECommerceData> arrayCommerceData = new ArrayList<ECommerceData>();

	public ECommerceData() {

		leerCSV = new LeerCSV();
	}

	public ECommerceData(String invoiceNo, String stockCode, String description, int quantity, Date invoiceDate,
			float unitPrice, String customerID, String country, LeerCSV leerCSV,
			ArrayList<ECommerceData> arrayCommerceData) {

		this.invoiceNo = invoiceNo;
		this.stockCode = stockCode;
		this.description = description;
		this.quantity = quantity;
		this.invoiceDate = invoiceDate;
		this.unitPrice = unitPrice;
		this.customerID = customerID;
		this.country = country;
		this.leerCSV = leerCSV;
		this.arrayCommerceData = arrayCommerceData;
	}

	public ECommerceData crearObjeto(String invoiceNo, String stockCode, String description, int quantity,
			Date invoiceDate, float unitPrice, String customerID, String country,
			ArrayList<ECommerceData> arrayCommerceData) {

		ECommerceData objetoCommerceData = new ECommerceData();

		objetoCommerceData.setInvoiceNo(invoiceNo);
		objetoCommerceData.setStockCode(stockCode);
		objetoCommerceData.setDescription(description);
		objetoCommerceData.setQuantity(quantity);
		objetoCommerceData.setInvoiceDate(invoiceDate);
		objetoCommerceData.setUnitPrice(unitPrice);
		objetoCommerceData.setCustomerID(customerID);
		objetoCommerceData.setCountry(country);
		objetoCommerceData.setArrayCommerceData(arrayCommerceData);

		return objetoCommerceData;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LeerCSV getLeerCSV() {
		return leerCSV;
	}

	public void setLeerCSV(LeerCSV leerCSV) {
		this.leerCSV = leerCSV;
	}

	public ArrayList<ECommerceData> getArrayCommerceData() {
		return arrayCommerceData;
	}

	public void setArrayCommerceData(ArrayList<ECommerceData> arrayCommerceData) {
		this.arrayCommerceData = arrayCommerceData;
	}

	public String findPartiallyByDescription() {
		

		String lista = "";
		lista = lista + "*************************************************************************************\n";

		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		formateador.setLenient(false);

		for (int i = 0; i < this.arrayCommerceData.size(); i++) {
			lista = lista + leerCSV.getArrayCommerceData().get(i).getCountry() + "\n";

			
			
		}
		return lista;

	}

	
}
