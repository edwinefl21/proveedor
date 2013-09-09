/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.wtf.proveedor.cotizacion.sever;

/**
 *
 * @author edwinefl
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

import main.java.com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.Item;
import main.java.com.wtf.proveedor.cotizacion.cotizacion.Proveedor;
import main.java.com.wtf.proveedor.cotizacion.util.CotizacionesUtil;

@WebService(endpointInterface = "main.java.com.wtf.proveedor.cotizacion.sever.ICotizaciones",serviceName = "ICotizaciones")
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
        
        DetalleCotizacion detalleCotizacion = new DetalleCotizacion();
        ArrayList<Item> items=new ArrayList<Item>();
        		
        Item item= new Item();
        item.setDescripcion("Computadores");
        item.setIdItem("COMP001");
        item.setPrecio(100000);
        items.add(item);
        
        Item item2= new Item();
        item2.setDescripcion("Zapatos");
        item2.setIdItem("ZAP001");
        item2.setPrecio(10000);
        items.add(item2);
        
        detalleCotizacion.setDetalle(items);
        
        cotizacion.setDetalleCotizacion(detalleCotizacion);
        //Total precio
        cotizacion.setTotalPrecio(CotizacionesUtil.calculaPrecioCotizacion(cotizacion));
        
        return cotizacion;
    }
    
    
}
// END SNIPPET: service