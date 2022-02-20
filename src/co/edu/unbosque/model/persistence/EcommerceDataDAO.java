package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.ECommerceData;

public class EcommerceDataDAO {

	private ArrayList<ECommerceData> arrayCommerceData = new ArrayList<ECommerceData>();

	public EcommerceDataDAO() {

	}

	public void uploadData() {
		BufferedReader bufferLectura = null;
		try {
			bufferLectura = new BufferedReader(new FileReader("data.csv"));

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyy");

			String linea = bufferLectura.readLine();

			while (linea != null) {
				ECommerceData eCommerce = new ECommerceData();
				String[] campo = linea.split(",");

				try {
					eCommerce.setInvoiceNo(campo[0]);
					eCommerce.setStockCode(campo[1]);
					eCommerce.setDescription(campo[2]);
					eCommerce.setQuantity(Integer.parseInt(campo[3]));

					try {

						eCommerce.setInvoiceDate((Date) formateador.parse(campo[4]));

					} catch (ParseException p) {

						System.out.println("Error en la fecha");
					}
					eCommerce.setUnitPrice(Float.parseFloat(campo[5]));
					eCommerce.setCustomerID(campo[6]);
					eCommerce.setCountry(campo[7]);

					arrayCommerceData.add(eCommerce);
				} catch (NumberFormatException e) {

				}

				linea = bufferLectura.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void findPartiallyByDescription() {

		for (int i = 0; i < arrayCommerceData.size(); i++) {

			System.out.println(arrayCommerceData.get(i).getInvoiceDate());
		}
	}

	public ArrayList<ECommerceData> getArrayCommerceData() {
		return arrayCommerceData;
	}

	public void setArrayCommerceData(ArrayList<ECommerceData> arrayCommerceData) {
		this.arrayCommerceData = arrayCommerceData;
	}
	
	

}
