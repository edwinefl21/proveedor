/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.client;

import java.util.Map;

import com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.Item;
import com.wtf.proveedor.cotizacion.util.CotizacionesUtil;

/**
 *
 * @author edwinefl
 */
public class ProveedorFile {
    public static void main(String args[]) throws Exception {
        System.out.println("getCotizacionFile called");
        Cotizacion cotizacion=CotizacionesUtil.readFile("C:/Files/Cotizacion.txt");

        System.out.println("Identificación cotización: " + cotizacion.getIdCotizacion());
        System.out.println("Fecha cotizacion: " + cotizacion.getFechaCotizacion());
        System.out.println("Precio Total: " + cotizacion.getTotalPrecio());
        System.out.println();
        System.out.println("idProveedor: " + cotizacion.getProveedor().getIdProveedor());
        System.out.println("Proveedor: " + cotizacion.getProveedor().getNombre());
        
         for (DetalleCotizacion detalle : cotizacion.getDetalleCotizacion()) {
              System.out.println("Producto item: " + detalle.getItem().getIdItem());
              System.out.println("         descripción: " + detalle.getItem().getDescripcion());
              System.out.println("         precio: " + detalle.getItem().getPrecio());
         }
      }
}
