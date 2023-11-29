package org.informatorio.servicio.ctacorriente;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaCorriente;
import org.informatorio.servicio.ctaservice.CtaService;
import org.informatorio.servicio.ctaservice.CtaServiceImpl;

public class ServicioCtaCorrienteImpl implements ServicioCtaCorriente {

    public static final String MENSAJE_CUENTA_AGREGADA = "Cuenta Corriente agregada con éxito!";

    CtaService ctaService = new CtaServiceImpl();

    @Override
    public void agregarCtaCorriente(Banco banco){
        Cliente cliente = ctaService.getCliente(banco);
        if(cliente != null) {
            double saldo = ctaService.getSaldo();
            CuentaCorriente nvaCuentaCorriente = new CuentaCorriente("Corriente", ctaService.getNombreCliente(cliente), saldo);
            cliente.agregarCuenta(nvaCuentaCorriente);
            System.out.println(MENSAJE_CUENTA_AGREGADA);
        }
    }
}
