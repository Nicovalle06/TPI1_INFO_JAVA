package org.informatorio.servicio.cuentas;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.domain.CuentaAhorro;
import org.informatorio.domain.CuentaCorriente;
import org.informatorio.input.InputConsoleService;

public class ServicioCuentasImpl implements ServicioCuentas {
    public static final String MENSAJE_INEXISTENCIA_CUENTAS = "No hay cuenta/s asociada/s a el cliente informado.";
    public static final String MENSAJE_SALDO_TOTAL = "El saldo total de todas sus cuentas es de $";
    public static final String MENSAJE_SELECCION_CUENTA = "Ingrese el tipo de cuenta en Nro. (1-Ahorro/2-Corriente): ";
    public static final String MENSAJE_OBTENER_SALDO = "Ingrese saldo para la cuenta: ";
    public static final String MENSAJE_TIPO_CUENTA_INVALIDA = "Tipo de cuenta ingresado inválida";
    public static final String MENSAJE_NRO_CUENTA_INVALIDA = "Nro de cuenta ingresada inválida";
    public static final String MENSAJE_NRO_CUENTA = "Ingrese el número de cuenta que desee eliminar: ";
    public static final String MENSAJE_ELIMINACION_CUENTA = "Se ha eliminado la cuenta correctamente!";
    public static final String MENSAJE_DEPOSITO_CUENTA = "Ingrese el número de cuenta que desee depositar: ";
    public static final String MENSAJE_RETIRO_DINERO = "Ingrese el número de cuenta para el retiro: ";
    public static final String MENSAJE_SALDO_RETIRO = "Ingrese el saldo: ";
    public static final String MENSAJE_DECORATIVO_CUENTAS = "===========Cuentas=============";



    @Override
    public void mostrarCuentas(Cliente cliente){
        if (!cliente.getCuentas().isEmpty()) {
            StringBuilder listaCuentas = new StringBuilder();
            for (Cuenta c : cliente.getCuentas()) {
                listaCuentas.append(String.format("NroCta:[%d] Titular:[%s] Tipo:[%s] Saldo:[%g]\n", c.getNroCuenta(), c.getTitular(), c.getTipoCta(), c.getSaldo()));
            }
            System.out.println(MENSAJE_DECORATIVO_CUENTAS);
            System.out.println(listaCuentas);
        }else {
            System.out.println(MENSAJE_INEXISTENCIA_CUENTAS);
        }
    }

    @Override
    public void consultaSaldoTotal(Cliente cliente){
        if (cliente.getCuentas().isEmpty()) {
            System.out.println(MENSAJE_INEXISTENCIA_CUENTAS);
        } else {
            double saldoTotal = cliente.consultaSaldoTotal();
            System.out.println(MENSAJE_SALDO_TOTAL + saldoTotal);
        }
    }

    @Override
    public int seleccionarCuenta(){
        System.out.print(MENSAJE_SELECCION_CUENTA);
        return InputConsoleService.getScanner().nextInt();
    }

    @Override
    public double obtenerSaldo(){
        System.out.print(MENSAJE_OBTENER_SALDO);
        return InputConsoleService.getScanner().nextDouble();
    }

    @Override
    public void mensajeTipoCta(){
        System.out.println(MENSAJE_TIPO_CUENTA_INVALIDA);
    }

    @Override
    public void eliminarCta(Cliente cliente){

        if (cliente.getCuentas().isEmpty()) {
            System.out.print(MENSAJE_INEXISTENCIA_CUENTAS);
        } else {
            mostrarCuentas(cliente);

            System.out.print(MENSAJE_NRO_CUENTA);
            int nroCta = InputConsoleService.getScanner().nextInt();

            Cuenta cuenta = null;
            for (Cuenta c : cliente.getCuentas()) {
                if (c.getNroCuenta() == nroCta) {
                    cuenta = c;
                    break;
                }
            }

            if(cuenta != null){
                cliente.eliminarCuenta(cuenta);
                System.out.println(MENSAJE_ELIMINACION_CUENTA);
            }else{
                System.out.println(MENSAJE_NRO_CUENTA_INVALIDA);
            }

        }
    }

    @Override
    public void depositoCta(Cliente cliente){
        if (cliente.getCuentas().isEmpty()) {
            System.out.print(MENSAJE_INEXISTENCIA_CUENTAS);
        } else {

            mostrarCuentas(cliente);

            System.out.print(MENSAJE_DEPOSITO_CUENTA);
            int nroCta = InputConsoleService.getScanner().nextInt();

            Cuenta cuenta = null;
            for (Cuenta c : cliente.getCuentas()) {
                if (c.getNroCuenta() == nroCta) {
                    cuenta = c;
                    break;
                }
            }
            if(cuenta != null) {
                System.out.print(MENSAJE_OBTENER_SALDO);
                double nvoSaldo = InputConsoleService.getScanner().nextDouble();
                if (cuenta.getTipoCta().equals("Ahorro")) {
                    ((CuentaAhorro) cuenta).calcularIteres(nvoSaldo);
                } else {
                    cuenta.depositar(nvoSaldo);
                }
            }else{
                System.out.println(MENSAJE_NRO_CUENTA_INVALIDA);
            }

        }
    }

    @Override
    public void retirarDinero(Cliente cliente){
        if (cliente.getCuentas().isEmpty()) {
            System.out.print(MENSAJE_INEXISTENCIA_CUENTAS);
        } else {

            mostrarCuentas(cliente);

            System.out.print(MENSAJE_RETIRO_DINERO);
            int nroCta = InputConsoleService.getScanner().nextInt();

            Cuenta cuenta = null;

            for (Cuenta c : cliente.getCuentas()) {
                if (c.getNroCuenta() == nroCta) {
                    cuenta = c;
                    break;
                }
            }

            if(cuenta != null) {
                System.out.print(MENSAJE_SALDO_RETIRO);
                double retiroSaldo = InputConsoleService.getScanner().nextDouble();
                if (cuenta.getTipoCta().equals("Ahorro")) {
                    cuenta.retirar(retiroSaldo);
                } else {
                    ((CuentaCorriente) cuenta).retirar(retiroSaldo);
                }
            }else{
                    System.out.println(MENSAJE_NRO_CUENTA_INVALIDA);
            }
        }
    }
}
