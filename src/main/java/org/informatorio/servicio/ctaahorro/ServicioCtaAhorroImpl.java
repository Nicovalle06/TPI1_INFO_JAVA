package org.informatorio.servicio.ctaahorro;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaAhorro;
import org.informatorio.servicio.ctaservice.CtaServiceImpl;
import org.informatorio.servicio.ctaservice.CtaService;

public class ServicioCtaAhorroImpl implements ServicioCtaAhorro {
    public static final String MENSAJE_CUENTA_AGREGADA = "Cuenta Ahorro agregada con éxito!";

    CtaService ctaService = new CtaServiceImpl();

    @Override
    public void agregarCtaAhorro(Banco banco){
        Cliente cliente = ctaService.getCliente(banco);
        if(cliente != null){
            double saldo = ctaService.getSaldo();
            CuentaAhorro nvaCuentaAhorro = new CuentaAhorro("Ahorro", ctaService.getNombreCliente(cliente), saldo);
            cliente.agregarCuenta(nvaCuentaAhorro);
            nvaCuentaAhorro.calcularIteres(saldo);
            System.out.println(MENSAJE_CUENTA_AGREGADA);
        }
    }
}
