/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.client;

import java.net.URL;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.Item;
import com.wtf.proveedor.cotizacion.sever.ICotizaciones;

/**
 *
 * @author edwinefl
 */
public class Client {
    private static final QName SERVICE_NAME = new QName("http://sever.cotizacion.proveedor.wtf.com/", "ICotizaciones");
    private static final QName PORT_NAME = new QName("http://sever.cotizacion.proveedor.wtf.com/", "CotizacionesImpl");


    private Client() {
    } 

    public static void main(String args[]) throws Exception {
        // Endpoint Address
        String endpointAddress = "http://localhost:8082/cotizaciones?wsdl";
        URL wsdllocation= new URL(endpointAddress);
        Service service = Service.create(wsdllocation, SERVICE_NAME);
        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        ICotizaciones hw = service.getPort(ICotizaciones.class);
        
        System.out.println();
        System.out.println("Cotizacion: ");
        
        Cotizacion cotizacion = hw.getCotizaciones();
        
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
