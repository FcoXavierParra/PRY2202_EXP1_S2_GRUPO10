

package com.mycompany.exp1_s2_grupo10.Services;

import com.mycompany.exp1_s2_grupo10.Models.Cuenta;

public class CuentaService {
    public void depositar(Cuenta cuenta, int monto) {
        cuenta.depositar(monto);
    }

    public void girar(Cuenta cuenta, int monto) {
        cuenta.girar(monto);
    }

    public void consultarSaldo(Cuenta cuenta) {
        cuenta.mostrarSaldo();
    }
}
