package org.informatorio.servicio.menu.ctacorriente;

import org.informatorio.domain.Cliente;

public interface MenuCtaCorriente {

    void agregarCtaCorriente(Cliente cliente, double saldo);
}
