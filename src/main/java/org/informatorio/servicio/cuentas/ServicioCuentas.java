package org.informatorio.servicio.cuentas;

import org.informatorio.domain.Cliente;

public interface ServicioCuentas {
    void mostrarCuentas(Cliente cliente);
    void consultaSaldoTotal(Cliente cliente);
    int seleccionarCuenta();
    double obtenerSaldo();
    void mensajeTipoCta();
    void eliminarCta(Cliente cliente);
    void depositoCta(Cliente cliente);
    void retirarDinero(Cliente cliente);
}
