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
import co.edu.unbosque.view.Vista;

public class EcommerceDataDAO {

	private ArrayList<ECommerceData> arrayCommerceData = new ArrayList<ECommerceData>();
	private Vista vista;

/**
 * El metodo uploadData se encarga de leer el archivo data.csv que es la informacion usada para este programa
 * 
 */
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
/**
 * el metodo indPartiallyByDescription hace un busqueda del objeto al recibir la descripcion y hacer un filtro de usqueda 
 * entre el mes inicial y el mes final
 * @param search
 * @param initMonth
 * @param endMonth
 */
	public void findPartiallyByDescription(String search, int initMonth, int endMonth) {

		int encontrado;

		for (int i = 0; i < arrayCommerceData.size(); i++) {

			encontrado = arrayCommerceData.get(i).getDescription().toLowerCase().indexOf(search.toLowerCase());

			Date fecha1 = this.ubicarMes(initMonth);
			Date fecha2 = this.ubicarMes(endMonth);

			if (arrayCommerceData.get(i).getInvoiceDate().after(fecha1)
					&& arrayCommerceData.get(i).getInvoiceDate().before(fecha2)) {

				if (encontrado != -1) {

					System.out.println(arrayCommerceData.get(i).getDescription() + " -- Unidades vendidas:  "
							+ arrayCommerceData.get(i).getQuantity() + "  ---En la fecha:        "
							+ arrayCommerceData.get(i).getInvoiceDate());

				}

			}

		}
	}
/**
 * El metodo ubicarmes, ubica el numero del mes dentro del formato SimpleDateFormat
 * @param date
 * @return
 */
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
/**
 * El metodo findByInvoiceNo se encarga de buscar los objetos por el InvoiceNo y mostrar una factura
 * de estos
 * @param codigo
 */
	public void findByInvoiceNo(String codigo) {

//		String codigo = "536365";
		for (int j = 0; j < arrayCommerceData.size(); j++) {

			if (arrayCommerceData.get(j).getInvoiceNo().equals(codigo)) {
				System.out.println("la factura solicitada con en numero de codigo     " + codigo + "" + "    es :    "
						+ arrayCommerceData.get(j).getInvoiceNo() + ",  " + arrayCommerceData.get(j).getStockCode()
						+ ",   " + arrayCommerceData.get(j).getDescription() + ",    "
						+ arrayCommerceData.get(j).getQuantity() + ",   " + arrayCommerceData.get(j).getInvoiceDate()
						+ ",    " + arrayCommerceData.get(j).getUnitPrice() + ",    "
						+ arrayCommerceData.get(j).getCustomerID() + ",     " + arrayCommerceData.get(j).getCountry()
						+ "\n");

			}
		}

	}

	/**
	 * El metodo sumTotalSales tiene como fin operacional mostrarme el totalde
	 * ventas, para esto, toma los datos de la ruta
	 * C:\\Users\\Perez\\Taller1/data.csv lee los datos Guarda estos en un arreglo
	 * por fila y separando estos espacios de arreglo por un .split (",") en una
	 * variable local llamada valorTotal se hace una suma ciclica de las posiciones
	 * del arreglo, [3] es decir Quantity y la posicion [5] es decir UnitPrice toma
	 * estos dos datos los pasa a tipo float y los multiplica para asi dar el valor
	 * total de ventas todo esto dentro de un try con sus correspondientes catch
	 * 
	 * @param variable
	 */
	public void sumTotalSales() {
		FileReader file;
		BufferedReader br;
		String registro;
		double valorTotal = 0;
		int count = 0;
		String ruta = "data.csv";

		try {
			file = new FileReader(ruta);
			br = new BufferedReader(file);
			while ((registro = br.readLine()) != null) {
				String[] campos = registro.split(",");

				try {
					valorTotal += Float.parseFloat(campos[3]) * Float.parseFloat(campos[5]);
				} catch (NumberFormatException ex) {
				}
			}

		} catch (IOException x) {
			System.out.println("Ocurrio un error buscando el archivo");
		}
		double resultado = valorTotal;
		System.out.println("TOTAL VENTAS :  " + "" + resultado + "$");
	}
/**
 * El metodo countByStockCode va a pedirle al ususario el stockcode
 * y este a su vez le va mostrar la cantidad del producto, se le aisgna una ruta
 * donde va a leer los datos (data.csv) Guarda estos en un arreglo
 * por fila y separando estos espacios de arreglo por un .split (",")
 * y va cada vez cuando pase por el arreglo [1] le va sumar 1 a la variable cantidad
 * y a la vez recorrera el arreglo [3]  
 * @param variable
 * @return
 */
	public Integer countByStockCode(String variable) {
		FileReader file;
		BufferedReader br;
		String registro;
		int cantidad = 0;
		String ruta = "data.csv";

		try {
			file = new FileReader(ruta);
			br = new BufferedReader(file);
			while ((registro = br.readLine()) != null) {
				String[] campos = registro.split(",");
				if (variable.equals(campos[1])) {
					try {
						cantidad += Integer.parseInt(campos[3]);
					} catch (NumberFormatException ex) {
					}
				}
			}
		} catch (IOException x) {
			System.out.println("Ocurrio un error buscando el archivo");
		}
		return cantidad;
	}

	public void avgMonthlySales() {
		FileReader file;
		BufferedReader br;
		String registro;
		double valorTotal = 0;
		int count = 0;
		String ruta = "data.csv";

		try {
			file = new FileReader(ruta);
			br = new BufferedReader(file);
			while ((registro = br.readLine()) != null) {
				String[] campos = registro.split(",");
				if (count != 0) {
					try {
						valorTotal += Float.parseFloat(campos[3]) * Float.parseFloat(campos[5]);
					} catch (NumberFormatException ex) {
					}
				}
				count++;
			}
		} catch (IOException x) {
			System.out.println("Ocurrio un error buscando el archivo");
		}
		double resultado = valorTotal / count;
		System.out.println(resultado);
	}

	public ArrayList<ECommerceData> getArrayCommerceData() {
		return arrayCommerceData;
	}

	public void setArrayCommerceData(ArrayList<ECommerceData> arrayCommerceData) {
		this.arrayCommerceData = arrayCommerceData;
	}

	

	
}
