package org.informatorio.servicio.menu.banco;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.input.InputConsoleService;

import java.util.Scanner;

public class MenuBancoImpl implements MenuBanco{

    Scanner sc = new Scanner(System.in);
    public static final String MENSAJE_NOMBRE_CLIENTE = "Ingrese el nombre del Cliente: ";
    public static final String MENSAJE_DIRECCION_CLIENTE = "Ingrese la dirección: ";
    public static final String MENSAJE_REGISTRO_CLIENTE = "Cliente registrado!";
    public static final String MENSAJE_NRO_CLIENTE = "Su Nro de cliente es: ";

    @Override
    public void registroCliente(Banco banco){
        System.out.print(MENSAJE_NOMBRE_CLIENTE);
        String nombre = sc.nextLine();

        System.out.print(MENSAJE_DIRECCION_CLIENTE);
        String direccion = sc.nextLine();


        Cliente cliente = new Cliente(nombre, direccion);
        banco.registrarCliente(cliente);
        System.out.println(MENSAJE_REGISTRO_CLIENTE);
        System.out.println(MENSAJE_NRO_CLIENTE + cliente.getNumeroUnico());


    }
}
