package org.informatorio.domain;

public class CuentaCorriente extends Cuenta{

    private double limSobregiroBco = 1000; //Establezco límite de sobregiro
    private double limiteSobregiro;

    public CuentaCorriente(Cuenta cuenta) {
        super(cuenta.getTipoCta(), cuenta.getTitular(), cuenta.getSaldo());
        this.limiteSobregiro = limSobregiroBco;
    }


    @Override
    public boolean retirar(double cantidad){
        if (cantidad < saldo + limiteSobregiro){
            saldo -= cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
            return false;
        }
    }
}
