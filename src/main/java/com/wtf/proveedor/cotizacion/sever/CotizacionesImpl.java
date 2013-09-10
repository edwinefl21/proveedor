/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.sever;

/**
 *
 * @author edwinefl
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

import com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.Item;
import com.wtf.proveedor.cotizacion.cotizacion.Proveedor;
import com.wtf.proveedor.cotizacion.util.CotizacionesUtil;

@WebService(endpointInterface = "com.wtf.proveedor.cotizacion.sever.ICotizaciones",serviceName = "ICotizaciones")
public class CotizacionesImpl implements ICotizaciones {
    
    /**
     * 
     * @return 
     */
    public Cotizacion getCotizaciones() {
        System.out.println("getCotizaciones called");
        Cotizacion cotizacion=new Cotizacion();
        cotizacion.setIdCotizacion("001");
        //Mandar fecha
        cotizacion.setFechaCotizacion(new Date());
        
        
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor("PRO001");
        proveedor.setNombre("Proveedor 001");
        cotizacion.setProveedor(proveedor);
        
        ArrayList<DetalleCotizacion> detalleCotizacion = new ArrayList<DetalleCotizacion>();
        		
        
        DetalleCotizacion detalle1= new DetalleCotizacion();
        detalle1.setCantidad(2);
        detalle1.setIdDetalleCotizacion(1);
        
        Item item= new Item();
        item.setDescripcion("Computadores");
        item.setIdItem("COMP001");
        item.setPrecio(100000);
        detalle1.setItem(item);
        
        detalleCotizacion.add(detalle1);
        cotizacion.setDetalleCotizacion(detalleCotizacion);

        //Total precio
        cotizacion.setTotalPrecio(CotizacionesUtil.calculaPrecioCotizacion(cotizacion));
        
        return cotizacion;
    }
    
    
}
// END SNIPPET: service