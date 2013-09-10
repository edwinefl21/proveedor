/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.Item;
import com.wtf.proveedor.cotizacion.cotizacion.Proveedor;

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

			ArrayList<DetalleCotizacion> detalleItems = new ArrayList<DetalleCotizacion>();
			// Leer el archivo linea por linea
			while ((strLinea = buffer.readLine()) != null) {
				detalleItems.add(llenarDetalle((String[]) strLinea.split(";")));
			}
			cotizacion.setDetalleCotizacion(detalleItems);
			
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

	public static DetalleCotizacion llenarDetalle(String[] linea) {

		DetalleCotizacion detalle = new DetalleCotizacion();
		if (linea != null && linea.length > 0) {
			detalle.setIdDetalleCotizacion(Integer.parseInt(linea[0]));
			detalle.setCantidad(Integer.parseInt(linea[1]));
			Item item=new Item();
			item.setIdItem(linea[2]);
			item.setDescripcion(linea[3]);
			item.setPrecio(Float.parseFloat(linea[4]));
			detalle.setItem(item);
		}
		return detalle;
	}

	public static float calculaPrecioCotizacion(Cotizacion cotizacion) {
		float sumaPrecio = 0;
		for (DetalleCotizacion detalle : cotizacion.getDetalleCotizacion()) {
			sumaPrecio += (detalle.getItem().getPrecio()*detalle.getCantidad());
		}
		return sumaPrecio;
	}

}
