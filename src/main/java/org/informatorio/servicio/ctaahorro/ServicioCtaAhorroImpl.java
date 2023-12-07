package org.informatorio.servicio.ctaahorro;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.domain.CuentaAhorro;

public class ServicioCtaAhorroImpl implements ServicioCtaAhorro {

    public static final String MENSAJE_CUENTA_AGREGADA = "Cuenta Ahorro agregada con éxito!";

    @Override
    public void agregarCtaAhorro(CuentaAhorro cuentaAhorro, double saldo){
        cuentaAhorro.calcularIteres(saldo);
        System.out.println(MENSAJE_CUENTA_AGREGADA);
    }
}
