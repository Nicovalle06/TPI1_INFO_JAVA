package org.informatorio.domain;

public class Cuenta {
    private static int nextNumeroCuenta = 1;

    private String tipoCta;
    private int nroCuenta;
    private String titular;
    protected Double saldo;

    public Cuenta() {
    }

    public Cuenta(String tipoCta,String titular, Double saldo) {
        this.nroCuenta = nextNumeroCuenta++;
        this.tipoCta = tipoCta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTipoCta() {
        return tipoCta;
    }

    public void setTipoCta(String tipoCta) {
        this.tipoCta = tipoCta;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double cantidad){
        saldo += cantidad;
        System.out.println("Depósito de $" + cantidad + " realizado. Nuevo saldo: $" + saldo);
    }
    public boolean retirar(double cantidad){
        if (cantidad <= saldo){
            saldo -= cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
            return false;
        }

    }
    public void consultaSaldo(){
        System.out.println("Su saldo es de $" + saldo);
    }
}
