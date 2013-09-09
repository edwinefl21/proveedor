/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.wtf.proveedor.cotizacion.client;

import java.util.Map;

import main.java.com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.Item;
import main.java.com.wtf.proveedor.cotizacion.util.CotizacionesUtil;

/**
 *
 * @author edwinefl
 */
public class ProveedorFile {
    public static void main(String args[]) throws Exception {
        System.out.println("getCotizacionFile called");
        Cotizacion cotizacion=CotizacionesUtil.readFile("C:/Files/Cotizacion.txt");

        System.out.println("Identificaci�n cotizaci�n: " + cotizacion.getIdCotizacion());
        System.out.println("Fecha cotizacion: " + cotizacion.getFechaCotizacion());
        System.out.println("Precio Total: " + cotizacion.getTotalPrecio());
        System.out.println();
        System.out.println("idProveedor: " + cotizacion.getProveedor().getIdProveedor());
        System.out.println("Proveedor: " + cotizacion.getProveedor().getNombre());
        
         for (Item item : cotizacion.getDetalleCotizacion().getDetalle()) {
              System.out.println("Producto item: " + item.getIdItem());
              System.out.println("         descripci�n: " + item.getDescripcion());
              System.out.println("         precio: " + item.getPrecio());
         }
      }
}
