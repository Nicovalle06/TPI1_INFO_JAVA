package org.informatorio.servicio.clientes;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public interface ServicioClientes {
    void mostrarClientes(Banco banco);

   Cliente buscaCliente(Banco banco);
   String getNombreTitular(Cliente cliente);
}
