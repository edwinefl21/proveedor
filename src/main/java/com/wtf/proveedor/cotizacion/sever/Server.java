/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.wtf.proveedor.cotizacion.sever;

/**
 *
 * @author edwinefl
 */
import javax.xml.ws.Endpoint;

public class Server {

    protected Server() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        CotizacionesImpl implementor = new CotizacionesImpl();
        String address = "http://localhost:8080/cotizaciones?wsdl";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
