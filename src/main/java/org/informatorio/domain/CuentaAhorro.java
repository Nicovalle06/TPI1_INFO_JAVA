package org.informatorio.domain;

public class CuentaAhorro extends Cuenta{
    private double interesBco = 10; //Defino una tasa de interés que manejará el banco la cuál será del 10%
    private double tasaInteres;

    public CuentaAhorro() {
    }

    public CuentaAhorro(Cuenta cuenta) {
        super(cuenta.getTipoCta(), cuenta.getTitular(), cuenta.getSaldo());
        this.tasaInteres = interesBco;
    }

    public void calcularIteres(double valor){
        double interes = valor * (getInteresBco()/100);
        saldo += interes;
        System.out.println("Se han agregado nuevos intereses de $"+ interes + " a su cuenta.");
        System.out.println("Depósito de $" + valor + " realizado. Nuevo saldo: $" + saldo);
    }

    public double getInteresBco() {
        return interesBco;
    }
}

