/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exp1_s2_grupo10.Models;

public class CuentaCredito extends Cuenta {
    public CuentaCredito(String numero) {
        super(numero);
    }

    @Override
    public void mostrarTipoCuenta() {
        System.out.println("Tipo de cuenta: Crédito");
    }
}