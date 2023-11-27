package org.informatorio.servicio.menu.clientes;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

import java.util.Optional;

public interface MenuClientes {
    void mostrarClientes(Banco banco);

   Cliente buscaCliente(Banco banco);
}
