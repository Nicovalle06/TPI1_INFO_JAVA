package org.informatorio.servicio.menu.ctacorriente;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaCorriente;

public class MenuCtaCorrienteImpl implements MenuCtaCorriente{

    public static final String MENSAJE_CUENTA_AGREGADA = "Cuenta Corriente agregada con éxito!";

    @Override
    public void agregarCtaCorriente(Cliente cliente, double saldo){
        CuentaCorriente nvaCuentaCorriente = new CuentaCorriente("Corriente", cliente.getNombre(), saldo);
        cliente.agregarCuenta(nvaCuentaCorriente);
        System.out.println(MENSAJE_CUENTA_AGREGADA);
    }
}
