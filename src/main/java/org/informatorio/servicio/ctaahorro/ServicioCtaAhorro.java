package org.informatorio.servicio.ctaahorro;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.domain.CuentaAhorro;

public interface ServicioCtaAhorro {
    void agregarCtaAhorro(CuentaAhorro cuentaAhorro, double saldo);
}
