package org.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int nextNumeroUnico = 1;
    private int numeroUnico;
    private String nombre;
    private String direccion;
    private List <Cuenta> cuentas;

    public Cliente() {
    }
    public Cliente(String nombre, String direccion) {
        this.numeroUnico = nextNumeroUnico++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public int getNumeroUnico() {

        return numeroUnico;
    }


    public void agregarCuenta(Cuenta cuenta){

        cuentas.add(cuenta);
    }

    public void eliminarCuenta(Cuenta cuenta){
        cuentas.remove(cuenta);
    }

    public double consultaSaldoTotal(){
        double saldoTotal = 0;
        for (Cuenta cuenta : cuentas) {
            saldoTotal += cuenta.getSaldo();
        }
        return saldoTotal;
    }
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
