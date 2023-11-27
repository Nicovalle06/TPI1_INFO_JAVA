package org.informatorio.servicio.menu.clientes;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.input.InputConsoleService;

import java.lang.reflect.Array;
import java.util.Optional;
import java.util.List;

public class MenuClientesImpl implements MenuClientes{

    public static final String MENSAJE_INGRESAR_NRO_CLIENTE = "Ingrese el número de cliente: ";
    public static final String MENSAJE_INEXISTENCIA_CLIENTES = "No hay cliente/s registrado/s.";
    public static final String MENSAJE_DECORATIVO_CLIENTES = "===========Clientes=============";
    @Override
    public void mostrarClientes(Banco banco){
        if(!banco.getClientes().isEmpty()) {
            StringBuilder listaClientes = new StringBuilder();
            for (Cliente c : banco.getClientes()) {
                listaClientes.append(String.format("ID[%d] %s \n", c.getNumeroUnico(), c.getNombre()));
            }
            System.out.println(MENSAJE_DECORATIVO_CLIENTES);
            System.out.println(listaClientes);
        }else {
            System.out.println(MENSAJE_INEXISTENCIA_CLIENTES);
        }
    }

    @Override
    public Cliente buscaCliente(Banco banco) {
        System.out.print(MENSAJE_INGRESAR_NRO_CLIENTE);
        int nroCliente = InputConsoleService.getScanner().nextInt();

        Cliente cliente = null;
        for (Cliente c : banco.getClientes()) {
            if (c.getNumeroUnico() == nroCliente) {
                cliente = c;
                break;
            }
        }

        if (cliente == null){
            System.out.println("No existe el cliente con el nro : " + nroCliente);
            return null;
        }else {
            return cliente;
        }

    }

}

