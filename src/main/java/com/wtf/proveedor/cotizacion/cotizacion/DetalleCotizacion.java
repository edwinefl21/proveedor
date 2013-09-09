/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.wtf.proveedor.cotizacion.cotizacion;

import java.util.ArrayList;

/**
 *
 * @author edwinefl
 */
public class DetalleCotizacion {
    ArrayList<Item> detalle;  
    int idDetalleCotizacion;
    int cantidad;
    
    public int getIdDetalleCotizacion() {
		return idDetalleCotizacion;
	}

	public void setIdDetalleCotizacion(int idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
   
    public ArrayList<Item> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Item> detalle) {
        this.detalle = detalle;
    }
    
    
    
}
