package org.informatorio.servicio.archivos;

import com.opencsv.CSVWriter;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.input.InputConsoleService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Comparator;

public class ArchivoServicioImpl implements ArchivoServicio{

    Scanner sc = new Scanner(System.in);
    public static final String MENSAJE_INGRESAR_NOMBRE_ARCHIVO= "Ingrese el nombre del archivo más su extensión: ";

    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\org\\informatorio\\recursos\\";
    public void exportarCuentasACsv(List<Cliente> clientes, String nombreArchivo){
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(nombreArchivo);
        try(CSVWriter writer = new CSVWriter(new FileWriter(ruta))){
            //Escribir encabezado
            String[] encabezados = {"Numero único del titular","Nombre de titular", "Saldo", "Tipo"};
            writer.writeNext(encabezados);


            //Datos de cuenta
            for(Cliente cliente: clientes){
                List<Cuenta> cuentas = cliente.getCuentas();
                cuentas.sort(Comparator.comparingDouble(Cuenta::getSaldo));
                for (Cuenta cuenta: cuentas) {
                    String[] datos = {
                            String.valueOf(cliente.getNumeroUnico()),
                            cliente.getNombre(),
                            String.valueOf(cuenta.getSaldo()),
                            cuenta.getTipoCta()
                    };
                    writer.writeNext(datos);
                }
            }
            writer.close();
            System.out.println("Se ha exportado el CSV exitosamente!");

        } catch (IOException e) {
            System.out.println(e.getMessage().concat(" Ubicacion del archivo: " + ruta));
            //throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String getNombreArchivo(){
        System.out.print(MENSAJE_INGRESAR_NOMBRE_ARCHIVO);
        return sc.nextLine();
    }
}
