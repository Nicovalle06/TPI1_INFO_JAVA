package org.informatorio.servicio.menu.principal;

import org.informatorio.input.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivoServicio;
import org.informatorio.servicio.banco.ServicioBanco;
import org.informatorio.servicio.clientes.ServicioClientes;
import org.informatorio.servicio.ctaahorro.ServicioCtaAhorro;
import org.informatorio.servicio.ctacorriente.ServicioCtaCorriente;
import org.informatorio.servicio.cuentas.ServicioCuentas;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public class MenuPrincipal implements MenuPrincipalImpl {

    private ServicioClientes servicioClientes;
    private ServicioCuentas servicioCuentas;
    private ServicioBanco servicioBanco;
    private ServicioCtaAhorro servicioCtaAhorro;
    private ServicioCtaCorriente servicioCtaCorriente;
    private ArchivoServicio archivoServicio;
    public MenuPrincipal(ServicioClientes servicioClientes, ServicioCuentas servicioCuentas, ServicioBanco servicioBanco, ServicioCtaAhorro servicioCtaAhorro,
                         ServicioCtaCorriente servicioCtaCorriente, ArchivoServicio archivoServicio) {
        this.servicioClientes = servicioClientes;
        this.servicioCuentas = servicioCuentas;
        this.servicioBanco = servicioBanco;
        this.servicioCtaAhorro = servicioCtaAhorro;
        this.servicioCtaCorriente = servicioCtaCorriente;
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

                    servicioBanco.registroCliente(banco);
                    break;

                case 2: //Listar clientes

                    servicioClientes.mostrarClientes(banco);
                    break;

                case 3: // Consultar saldos

                    Cliente clientes = servicioClientes.buscaCliente(banco);
                    if (clientes != null) {
                        servicioCuentas.mostrarCuentas(clientes);
                    }
                    break;

                case 4: //Agregar cuenta a un cliente existente

                    int tpCta = servicioCuentas.seleccionarCuenta();

                    if (tpCta == 1) {

                        servicioCtaAhorro.agregarCtaAhorro(banco);

                    } else if (tpCta == 2) {

                        servicioCtaCorriente.agregarCtaCorriente(banco);
                    } else {

                        System.out.println("Error: Tipo de cuenta inválida!!");
                    }

                    break;

                case 5: //Eliminar cuenta de un cliente

                    Cliente eliminaCtaCliente = servicioClientes.buscaCliente(banco);
                    if (eliminaCtaCliente != null) {
                        servicioCuentas.eliminarCta(eliminaCtaCliente);
                    }
                    break;

                case 6: //Depositar dinero a una cuenta

                    Cliente depositoCtaCliente = servicioClientes.buscaCliente(banco);
                    if (depositoCtaCliente != null) {
                        servicioCuentas.depositoCta(depositoCtaCliente);
                    }
                    break;

                case 7: //Retirar dinero de una cuenta

                    Cliente retiroCtaCliente = servicioClientes.buscaCliente(banco);
                    if (retiroCtaCliente != null) {
                        servicioCuentas.retirarDinero(retiroCtaCliente);
                    }
                    break;

                case 8: //Consultar saldo total de un cliente

                    Cliente cliSaldo = servicioClientes.buscaCliente(banco);
                    if (cliSaldo != null) {
                        servicioCuentas.consultaSaldoTotal(cliSaldo);
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
