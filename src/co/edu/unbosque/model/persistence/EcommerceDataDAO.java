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

	public void findPartiallyByDescription(String search, int initMonth, int endMonth) {

		int encontrado;

		for (int i = 0; i < arrayCommerceData.size(); i++) {

			encontrado = arrayCommerceData.get(i).getDescription().toLowerCase().indexOf(search.toLowerCase());

			Date fecha1 = this.ubicarMes(initMonth);
			Date fecha2 = this.ubicarMes(endMonth);

			if (arrayCommerceData.get(i).getInvoiceDate().after(fecha1)
					&& arrayCommerceData.get(i).getInvoiceDate().before(fecha2)) {

				if (encontrado != -1) {

					System.out.println(arrayCommerceData.get(i).getDescription() + "           "
							+ arrayCommerceData.get(i).getInvoiceDate());

				}

			}

		}
	}

	public Date ubicarMes(int date) {

		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

		Date fechaSeleccionada = null;

		try {

			fechaSeleccionada = formateador.parse("01/" + date + "/2011");
		} catch (ParseException e) {
			e.printStackTrace();

		}

		return fechaSeleccionada;

	}

	public ArrayList<ECommerceData> getArrayCommerceData() {
		return arrayCommerceData;
	}

	public void setArrayCommerceData(ArrayList<ECommerceData> arrayCommerceData) {
		this.arrayCommerceData = arrayCommerceData;
	}
	
	

}
