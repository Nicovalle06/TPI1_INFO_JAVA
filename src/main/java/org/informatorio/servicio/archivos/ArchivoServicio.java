package org.informatorio.servicio.archivos;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;

import java.util.List;

public interface ArchivoServicio {
    void exportarCuentasACsv(List<Cliente> clientes, String nombreArchivo);
    String getNombreArchivo();
}
