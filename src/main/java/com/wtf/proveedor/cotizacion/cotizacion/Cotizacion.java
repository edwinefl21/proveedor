/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.cotizacion;

/**
 *
 * @author edwinefl
 */
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.wtf.proveedor.cotizacion.cotizacion.DetalleCotizacion;
import com.wtf.proveedor.cotizacion.cotizacion.Proveedor;

public class Cotizacion {
    
    private String idCotizacion;
    private Date fechaCotizacion;	
    private float totalPrecio;
    private Proveedor proveedor;
    private ArrayList<DetalleCotizacion> detalleCotizacion;
    
	public Cotizacion(){}
    
    public String getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(String idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Date getFechaCotizacion() {
		return fechaCotizacion;
	}
	public void setFechaCotizacion(Date fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}
	public float getTotalPrecio() {
		return totalPrecio;
	}
	public void setTotalPrecio(float totalPrecio) {
		this.totalPrecio = totalPrecio;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public ArrayList<DetalleCotizacion> getDetalleCotizacion() {
		return detalleCotizacion;
	}

	public void setDetalleCotizacion(ArrayList<DetalleCotizacion> detalleCotizacion) {
		this.detalleCotizacion = detalleCotizacion;
	}
	
  
}
