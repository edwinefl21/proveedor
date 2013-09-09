/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.wtf.proveedor.cotizacion.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import main.java.com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.Item;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.Proveedor;

/**
 * 
 * @author edwinefl
 */
public class CotizacionesUtil {
	public static Cotizacion readFile(String configurationFilePath) {
		Cotizacion cotizacion = new Cotizacion();
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(configurationFilePath);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el Buffer de Lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			String strLinea;

			cotizacion.setFechaCotizacion(new Date());

			// Leemos el encabezado
			strLinea = buffer.readLine();
			DetalleCotizacion detalle = new DetalleCotizacion();
			// Leemos el encabezado el encabezado
			llenarCotizacion(cotizacion, (String[]) strLinea.split(";"));

			ArrayList<Item> detalleItems = new ArrayList<Item>();
			// Leer el archivo linea por linea
			while ((strLinea = buffer.readLine()) != null) {
				detalleItems.add(llenarDetalle((String[]) strLinea.split(";")));
			}
			detalle.setDetalle(detalleItems);
			cotizacion.setDetalleCotizacion(detalle);
			//Total precio
	        cotizacion.setTotalPrecio(CotizacionesUtil.calculaPrecioCotizacion(cotizacion));

			// Cerramos el archivo
			entrada.close();
		} catch (Exception e) { // Catch de excepciones
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
		return cotizacion;
	}

	public static void llenarCotizacion(Cotizacion cotizacion, String[] linea) {

		if (linea != null && linea.length > 0) {
			Proveedor proveedor = new Proveedor();
			proveedor.setIdProveedor(linea[0]);
			proveedor.setNombre(linea[1]);
			cotizacion.setProveedor(proveedor);
			cotizacion.setIdCotizacion(linea[2]);
			// Capturar fecha
			cotizacion.setFechaCotizacion(new Date());
		}
	}

	public static Item llenarDetalle(String[] linea) {

		Item item = new Item();
		if (linea != null && linea.length > 0) {
			item.setIdItem(linea[0]);
			item.setDescripcion(linea[1]);
			item.setPrecio(Float.parseFloat(linea[2]));
		}
		return item;
	}

	public static float calculaPrecioCotizacion(Cotizacion cotizacion) {
		float sumaPrecio = 0;
		for (Item item : cotizacion.getDetalleCotizacion().getDetalle()) {
			sumaPrecio += item.getPrecio();
		}
		return sumaPrecio;
	}

}
