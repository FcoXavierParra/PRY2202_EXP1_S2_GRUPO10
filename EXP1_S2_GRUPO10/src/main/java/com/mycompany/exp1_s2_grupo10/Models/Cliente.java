/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exp1_s2_grupo10.Models;

public class Cliente implements IMostrable {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuenta;

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, Cuenta cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    public static boolean validarRut(String rut) {
        rut = rut.replace(".", "").replace("-", "").toUpperCase();
        if (!rut.matches("\\d{7,8}[0-9K]")) return false;

        int suma = 0, factor = 2;
        for (int i = rut.length() - 2; i >= 0; i--) {
            suma += Character.getNumericValue(rut.charAt(i)) * factor;
            factor = factor == 7 ? 2 : factor + 1;
        }
        int dvEsperado = 11 - (suma % 11);
        char dv = rut.charAt(rut.length() - 1);
        String dvCalculado = dvEsperado == 11 ? "0" : dvEsperado == 10 ? "K" : String.valueOf(dvEsperado);
        return dvCalculado.equals(String.valueOf(dv));
    }

    public void mostrarDatos() {
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Teléfono: " + telefono);
        cuenta.mostrarTipoCuenta();
        System.out.println("Número de cuenta: " + cuenta.getNumero());
        cuenta.mostrarSaldo();
        }

    public String getRut() { return rut; }
    public Cuenta getCuenta() { return cuenta; }
}