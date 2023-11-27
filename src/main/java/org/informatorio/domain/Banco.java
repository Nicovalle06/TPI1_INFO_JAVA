package org.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> cliente = new ArrayList<>();


    public void registrarCliente(Cliente clientes){
        cliente.add(clientes);
    }

    public List<Cliente> getClientes() {
        return cliente;
    }


}
