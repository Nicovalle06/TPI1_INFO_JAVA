package org.informatorio.servicio.ctaservice;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public interface CtaService {
    void agregaCta(Cliente cliente, int tpCta);
}
