/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.cotizacion;

import java.util.ArrayList;

/**
 *
 * @author edwinefl
 */
public class DetalleCotizacion {
    Item item;  
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
   
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    
}
