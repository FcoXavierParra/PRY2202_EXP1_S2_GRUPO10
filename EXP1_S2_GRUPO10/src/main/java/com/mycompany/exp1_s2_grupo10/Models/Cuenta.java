/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exp1_s2_grupo10.Models;

/*@author bclaros y fparraa*/

public abstract class Cuenta {
    private String numero;
    private int saldo;

    public Cuenta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            mostrarSaldo();
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0.");
        }
    }

    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto a girar debe ser mayor a 0.");
        } else if (monto > saldo) {
            System.out.println("No puede girar más del saldo disponible.");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado con éxito!");
            mostrarSaldo();
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual: " + saldo + " pesos");
    }

    public String getNumero() {
        return numero;
    }

    public int getSaldo() {
        return saldo;
    }
    public abstract void mostrarTipoCuenta();
}

