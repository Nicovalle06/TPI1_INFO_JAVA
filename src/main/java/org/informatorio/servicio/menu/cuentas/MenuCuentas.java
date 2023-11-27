package org.informatorio.servicio.menu.cuentas;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;

public interface MenuCuentas {
    void mostrarCuentas(Cliente cliente);
    void consultaSaldoTotal(Cliente cliente);
    int seleccionarCuenta();
    double obtenerSaldo();
    void mensajeTipoCta();
    void eliminarCta(Cliente cliente);
    void depositoCta(Cliente cliente);
    void retirarDinero(Cliente cliente);
}
