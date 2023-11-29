package org.informatorio.servicio.ctaservice;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public interface CtaService {
    double getSaldo();
    String getNombreCliente(Cliente cliente);
    Cliente getCliente(Banco banco);
}
