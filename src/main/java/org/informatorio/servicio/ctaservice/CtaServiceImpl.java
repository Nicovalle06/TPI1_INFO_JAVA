package org.informatorio.servicio.ctaservice;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.servicio.clientes.ServicioClientes;
import org.informatorio.servicio.clientes.ServicioClientesImpl;
import org.informatorio.servicio.cuentas.ServicioCuentas;
import org.informatorio.servicio.cuentas.ServicioCuentasImpl;

public class CtaServiceImpl implements CtaService{

    ServicioClientes servicioClientes = new ServicioClientesImpl();
    ServicioCuentas servicioCuentas = new ServicioCuentasImpl();

    @Override
    public String getNombreCliente(Cliente cliente){
        return servicioClientes.getNombreTitular(cliente);
    }

    @Override
    public Cliente getCliente(Banco banco){
        return servicioClientes.buscaCliente(banco);
    }

    @Override
    public double getSaldo(){
        return servicioCuentas.obtenerSaldo();
    }
}
