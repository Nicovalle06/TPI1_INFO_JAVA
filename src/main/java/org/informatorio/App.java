package org.informatorio;

import org.informatorio.input.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivoServicio;
import org.informatorio.servicio.archivos.ArchivoServicioImpl;
import org.informatorio.servicio.menu.banco.MenuBancoImpl;
import org.informatorio.servicio.menu.banco.MenuBanco;
import org.informatorio.servicio.menu.clientes.MenuClientesImpl;
import org.informatorio.servicio.menu.clientes.MenuClientes;
import org.informatorio.servicio.menu.cuentas.MenuCuentasImpl;
import org.informatorio.servicio.menu.cuentas.MenuCuentas;
import org.informatorio.servicio.menu.ctaahorro.MenuCtaAhorroImpl;
import org.informatorio.servicio.menu.ctaahorro.MenuCtaAhorro;
import org.informatorio.servicio.menu.ctacorriente.MenuCtaCorrienteImpl;
import org.informatorio.servicio.menu.ctacorriente.MenuCtaCorriente;
import org.informatorio.servicio.menu.principal.MenuPrincipal;


public class App {
    public static void main( String[] args ){
    // Creo scanner
    InputConsoleService.createScanner();

    MenuBanco menuBanco = new MenuBancoImpl();
    MenuClientes menuClientes = new MenuClientesImpl();
    MenuCuentas menuCuentas = new MenuCuentasImpl();
    MenuCtaAhorro menuCtaAhorro = new MenuCtaAhorroImpl();
    MenuCtaCorriente menuCtaCorriente = new MenuCtaCorrienteImpl();
    ArchivoServicio archivoServicio = new ArchivoServicioImpl();

    MenuPrincipal menuPrincipal = new MenuPrincipal(menuClientes, menuCuentas, menuBanco, menuCtaAhorro, menuCtaCorriente, archivoServicio);

    menuPrincipal.iniciar();

    //Cerrar el scanner
    InputConsoleService.closeScanner();
    }
}
