package org.informatorio.servicio.ctacorriente;


import org.informatorio.servicio.ctaservice.CtaService;
import org.informatorio.servicio.ctaservice.CtaServiceImpl;

public class ServicioCtaCorrienteImpl implements ServicioCtaCorriente {

    public static final String MENSAJE_CUENTA_AGREGADA = "Cuenta Corriente agregada con éxito!";


    @Override
    public void agregarCtaCorriente(){
            System.out.println(MENSAJE_CUENTA_AGREGADA);
    }
}
