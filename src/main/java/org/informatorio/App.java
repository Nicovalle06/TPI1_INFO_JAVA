package org.informatorio;

import org.informatorio.input.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivoServicio;
import org.informatorio.servicio.archivos.ArchivoServicioImpl;
import org.informatorio.servicio.banco.ServicioBancoImpl;
import org.informatorio.servicio.banco.ServicioBanco;
import org.informatorio.servicio.clientes.ServicioClientesImpl;
import org.informatorio.servicio.clientes.ServicioClientes;
import org.informatorio.servicio.cuentas.ServicioCuentasImpl;
import org.informatorio.servicio.cuentas.ServicioCuentas;
import org.informatorio.servicio.ctaahorro.ServicioCtaAhorroImpl;
import org.informatorio.servicio.ctaahorro.ServicioCtaAhorro;
import org.informatorio.servicio.ctacorriente.ServicioCtaCorrienteImpl;
import org.informatorio.servicio.ctacorriente.ServicioCtaCorriente;
import org.informatorio.servicio.principal.MenuPrincipal;


public class App {
    public static void main( String[] args ){
    // Creo scanner
    InputConsoleService.createScanner();

    ServicioBanco servicioBanco = new ServicioBancoImpl();
    ServicioClientes servicioClientes = new ServicioClientesImpl();
    ServicioCuentas servicioCuentas = new ServicioCuentasImpl();
    ServicioCtaAhorro servicioCtaAhorro = new ServicioCtaAhorroImpl();
    ServicioCtaCorriente servicioCtaCorriente = new ServicioCtaCorrienteImpl();
    ArchivoServicio archivoServicio = new ArchivoServicioImpl();

    MenuPrincipal menuPrincipal = new MenuPrincipal(servicioClientes, servicioCuentas, servicioBanco, servicioCtaAhorro, servicioCtaCorriente, archivoServicio);

    menuPrincipal.iniciar();

    //Cerrar el scanner
    InputConsoleService.closeScanner();
    }
}
