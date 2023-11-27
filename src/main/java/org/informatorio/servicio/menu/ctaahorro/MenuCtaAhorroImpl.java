package org.informatorio.servicio.menu.ctaahorro;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaAhorro;

public class MenuCtaAhorroImpl implements MenuCtaAhorro{
    public static final String MENSAJE_CUENTA_AGREGADA = "Cuenta Ahorro agregada con éxito!";

    @Override
    public void agregarCtaAhorro(Cliente cliente, double saldo){
        CuentaAhorro nvaCuentaAhorro = new CuentaAhorro("Ahorro", cliente.getNombre(), saldo);
        cliente.agregarCuenta(nvaCuentaAhorro);
        nvaCuentaAhorro.calcularIteres(saldo);
        System.out.println(MENSAJE_CUENTA_AGREGADA);
    }
}
