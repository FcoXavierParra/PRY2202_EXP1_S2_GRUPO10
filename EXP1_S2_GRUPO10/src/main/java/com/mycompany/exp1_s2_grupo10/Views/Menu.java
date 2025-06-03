/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exp1_s2_grupo10.Views;
import com.mycompany.exp1_s2_grupo10.Models.*;
import com.mycompany.exp1_s2_grupo10.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Cliente> clientes = new ArrayList<>();
    private final ClienteService clienteService = new ClienteService();
    private final CuentaService cuentaService = new CuentaService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> verCliente();
                case 3 -> operarCuenta(true);
                case 4 -> operarCuenta(false);
                case 5 -> consultarSaldo();
                case 6 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

   private void registrarCliente() {
    System.out.print("Ingrese Rut (formato: 12.345.678-9): ");
    String rut = scanner.nextLine();
    if (!Cliente.validarRut(rut)) {
        System.out.println("RUT inválido. Registro cancelado.");
        return;
    }

    Cliente existente = clienteService.buscarClientePorRut(clientes, rut);
    if (existente != null) {
        System.out.println("El cliente ya está registrado.");
        System.out.print("Tipo de cuenta asociada: ");
        existente.getCuenta().mostrarTipoCuenta();
        return;
    }

    System.out.print("Ingrese nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese apellido paterno: ");
    String apPat = scanner.nextLine();
    System.out.print("Ingrese apellido materno: ");
    String apMat = scanner.nextLine();
    System.out.print("Ingrese domicilio: ");
    String dom = scanner.nextLine();
    System.out.print("Ingrese comuna: ");
    String comuna = scanner.nextLine();
    System.out.print("Ingrese teléfono: ");
    String fono = scanner.nextLine();

    String numCuenta;
    while (true) {
        System.out.print("Ingrese número de cuenta (9 dígitos): ");
        numCuenta = scanner.nextLine();
        if (numCuenta.matches("\\d{9}")) break;
        System.out.println("Número de cuenta inválido. Debe tener exactamente 9 dígitos.");
    }

    int tipo;
    while (true) {
        System.out.print("Tipo de cuenta (1=Corriente, 2=Ahorro, 3=Crédito): ");
        tipo = scanner.nextInt(); scanner.nextLine();
        if (tipo >= 1 && tipo <= 3) break;
        System.out.println("Tipo de cuenta inválido. Intente nuevamente.");
    }

    Cuenta cuenta = switch (tipo) {
        case 1 -> new CuentaCorriente(numCuenta);
        case 2 -> new CuentaAhorro(numCuenta);
        case 3 -> new CuentaCredito(numCuenta);
        default -> null; // ya validado arriba
    };

    Cliente nuevo = new Cliente(rut, nombre, apPat, apMat, dom, comuna, fono, cuenta);
    clientes.add(nuevo);
    System.out.println("Cliente registrado exitosamente.");
}
   
    private void verCliente() {
        System.out.print("Ingrese Rut del cliente: ");
        String rut = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorRut(clientes, rut);
        if (cliente != null) cliente.mostrarDatos();
        else System.out.println("Cliente no encontrado.");
    }

    private void operarCuenta(boolean esDeposito) {
        System.out.print("Ingrese número de cuenta: ");
        String num = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorCuenta(clientes, num);
        if (cliente != null) {
            System.out.print("Ingrese monto: ");
            int monto = scanner.nextInt(); scanner.nextLine();
            if (esDeposito) cuentaService.depositar(cliente.getCuenta(), monto);
            else cuentaService.girar(cliente.getCuenta(), monto);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private void consultarSaldo() {
        System.out.print("Ingrese número de cuenta: ");
        String num = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorCuenta(clientes, num);
        if (cliente != null) cuentaService.consultarSaldo(cliente.getCuenta());
        else System.out.println("Cuenta no encontrada.");
    }
}
