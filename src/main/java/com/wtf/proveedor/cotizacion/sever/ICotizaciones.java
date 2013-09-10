/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtf.proveedor.cotizacion.sever;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.wtf.proveedor.cotizacion.cotizacion.Cotizacion;

/**
 *
 * @author edwinefl
 */
@WebService
public interface ICotizaciones {
    
	Cotizacion getCotizaciones();
    
}
