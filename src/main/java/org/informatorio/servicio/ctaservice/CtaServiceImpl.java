package org.informatorio.servicio.ctaservice;

import org.informatorio.domain.*;
import org.informatorio.input.InputConsoleService;
import org.informatorio.servicio.clientes.ServicioClientes;
import org.informatorio.servicio.clientes.ServicioClientesImpl;
import org.informatorio.servicio.cuentas.ServicioCuentas;
import org.informatorio.servicio.cuentas.ServicioCuentasImpl;
import org.informatorio.servicio.ctaahorro.ServicioCtaAhorroImpl;
import org.informatorio.servicio.ctacorriente.ServicioCtaCorrienteImpl;


public class CtaServiceImpl implements CtaService{

    private String descriTpCta;
    ServicioCtaAhorroImpl servicioCtaAhorro = new ServicioCtaAhorroImpl();
    ServicioCtaCorrienteImpl servicioCtaCorriente = new ServicioCtaCorrienteImpl();
    ServicioCuentas servicioCuentas = new ServicioCuentasImpl();

    @Override
    public void agregaCta(Cliente cliente, int tpCta){
        double saldo = servicioCuentas.obtenerSaldo();

        descriTpCta = (tpCta == 1) ? "Ahorro" : "Corriente";

        Cuenta cuenta = new Cuenta(descriTpCta, cliente.getNombre(), saldo);

        if (tpCta == 1) {
            CuentaAhorro  cuentaAhorro = new CuentaAhorro(cuenta);
            cliente.agregarCuenta(cuentaAhorro);
            servicioCtaAhorro.agregarCtaAhorro(cuentaAhorro, saldo);

        } else if (tpCta == 2) {
            CuentaCorriente  cuentaCorriente = new CuentaCorriente(cuenta);
            cliente.agregarCuenta(cuentaCorriente);
            servicioCtaCorriente.agregarCtaCorriente();

        } else {

            System.out.println("Error: Tipo de cuenta inválida!!");
        }
    }

}
