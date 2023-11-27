package org.informatorio.servicio.menu.principal;

import org.informatorio.input.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivoServicio;
import org.informatorio.servicio.menu.banco.MenuBanco;
import org.informatorio.servicio.menu.clientes.MenuClientes;
import org.informatorio.servicio.menu.ctaahorro.MenuCtaAhorro;
import org.informatorio.servicio.menu.ctacorriente.MenuCtaCorriente;
import org.informatorio.servicio.menu.cuentas.MenuCuentas;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public class MenuPrincipal implements MenuPrincipalImpl {

    private  MenuClientes menuClientes;
    private MenuCuentas menuCuentas;
    private MenuBanco menuBanco;
    private MenuCtaAhorro menuCtaAhorro;
    private MenuCtaCorriente menuCtaCorriente;
    private ArchivoServicio archivoServicio;
    public MenuPrincipal(MenuClientes menuClientes, MenuCuentas menuCuentas, MenuBanco menuBanco, MenuCtaAhorro menuCtaAhorro, MenuCtaCorriente menuCtaCorriente, ArchivoServicio archivoServicio) {
        this.menuClientes = menuClientes;
        this.menuCuentas = menuCuentas;
        this.menuBanco = menuBanco;
        this.menuCtaAhorro = menuCtaAhorro;
        this.menuCtaCorriente = menuCtaCorriente;
        this.archivoServicio = archivoServicio;
    }

    public MenuPrincipal() {
    }

    Banco banco = new Banco();
    @Override
    public void iniciar() {
        int opc;
        do {
            System.out.println("==================================================");
            System.out.println("Bienvenidos al Banco. ¿Qué acción desea realizar?");
            System.out.println("1. Registrar un nuevo cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Consultar cuentas");
            System.out.println("4. Agregar cuenta a un cliente existente");
            System.out.println("5. Eliminar cuenta de un cliente");
            System.out.println("6. Depositar dinero en una cuenta");
            System.out.println("7. Retirar dinero de una cuenta");
            System.out.println("8. Consultar saldo total de un cliente");
            System.out.println("9. Exportar cuentas bancarias");
            System.out.println("10. Salir");
            System.out.println("==================================================");

            System.out.print("Ingrese una opcion: ");
            opc = InputConsoleService.getScanner().nextInt();

            switch (opc) {
                case 1: //Registrar un nuevo cliente

                    menuBanco.registroCliente(banco);
                    break;

                case 2: //Listar clientes

                    menuClientes.mostrarClientes(banco);
                    break;

                case 3: // Consultar saldos

                    Cliente clientes = menuClientes.buscaCliente(banco);
                    if (clientes != null) {
                        menuCuentas.mostrarCuentas(clientes);
                    }
                    break;

                case 4: //Agregar cuenta a un cliente existente

                    Cliente nvaCtaCliente = menuClientes.buscaCliente(banco);

                    if (nvaCtaCliente != null) {

                        int tpCta = menuCuentas.seleccionarCuenta();
                        if (tpCta == 1) {
                            double saldo = menuCuentas.obtenerSaldo();
                            menuCtaAhorro.agregarCtaAhorro(nvaCtaCliente, saldo);

                        } else if (tpCta == 2) {
                            double saldo = menuCuentas.obtenerSaldo();
                            menuCtaCorriente.agregarCtaCorriente(nvaCtaCliente, saldo);

                        }
                    }
                    break;

                case 5: //Eliminar cuenta de un cliente

                    Cliente eliminaCtaCliente = menuClientes.buscaCliente(banco);
                    if (eliminaCtaCliente != null) {
                        menuCuentas.eliminarCta(eliminaCtaCliente);
                    }
                    break;

                case 6: //Depositar dinero a una cuenta

                    Cliente depositoCtaCliente = menuClientes.buscaCliente(banco);
                    if (depositoCtaCliente != null) {
                        menuCuentas.depositoCta(depositoCtaCliente);
                    }
                    break;

                case 7: //Retirar dinero de una cuenta

                    Cliente retiroCtaCliente = menuClientes.buscaCliente(banco);
                    if (retiroCtaCliente != null) {
                        menuCuentas.retirarDinero(retiroCtaCliente);
                    }
                    break;

                case 8: //Consultar saldo total de un cliente

                    Cliente cliSaldo = menuClientes.buscaCliente(banco);
                    if (cliSaldo != null) {
                        menuCuentas.consultaSaldoTotal(cliSaldo);
                    }
                    break;

                case 9: //Exportar cuentas de un cliente

                    String nomArch = archivoServicio.getNombreArchivo();
                    System.out.println("=======Exportando Cuentas del Banco=======");
                    archivoServicio.exportarCuentasACsv(banco.getClientes(), nomArch);


            }
        }while (opc != 10) ;
    }
}
