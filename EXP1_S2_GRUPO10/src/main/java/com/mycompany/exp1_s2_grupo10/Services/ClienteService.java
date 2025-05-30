package com.mycompany.exp1_s2_grupo10.Services;

import com.mycompany.exp1_s2_grupo10.Models.Cliente;
import java.util.List;


public class ClienteService {
    public Cliente buscarClientePorRut(List<Cliente> clientes, String rut) {
        String normalizado = rut.replace(".", "").replace("-", "");
        for (Cliente c : clientes) {
            if (c != null && c.getRut().replace(".", "").replace("-", "").equals(normalizado)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCuenta(List<Cliente> clientes, String numeroCuenta) {
        for (Cliente c : clientes) {
            if (c != null && c.getCuenta().getNumero().equals(numeroCuenta)) {
                return c;
            }
        }
        return null;
    }
}
