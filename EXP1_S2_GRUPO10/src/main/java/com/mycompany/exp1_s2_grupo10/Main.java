/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*@author bclaros y fparraa*/


package com.mycompany.exp1_s2_grupo10;
import com.mycompany.exp1_s2_grupo10.Models.Cliente;
import com.mycompany.exp1_s2_grupo10.Models.Cuenta;
import com.mycompany.exp1_s2_grupo10.Services.ClienteService;
import com.mycompany.exp1_s2_grupo10.Services.CuentaService;
import com.mycompany.exp1_s2_grupo10.Models.CuentaCorriente;
import com.mycompany.exp1_s2_grupo10.Models.CuentaAhorro;
import com.mycompany.exp1_s2_grupo10.Models.CuentaCredito;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        ClienteService clienteService = new ClienteService();
        CuentaService cuentaService = new CuentaService();

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
                case 1:
                    String rut;
                    while (true) {
                        System.out.print("Ingrese Rut (formato: 12.345.678-9): ");
                        rut = scanner.nextLine();
                       
                        Cliente existente = clienteService.buscarClientePorRut(clientes, rut);

                        if (existente != null) {
                            System.out.println("El cliente ya está registrado.");
                            System.out.print("Tipo de cuenta asociada: ");
                            existente.getCuenta().mostrarTipoCuenta();
                            continue; // Salta el registro
                        }

                        
                        Cuenta cuentaDummy = new CuentaCorriente("000000000"); // cuenta temporal para validación
                        Cliente temp = new Cliente(rut, "", "", "", "", "", "", cuentaDummy);
                        if (!temp.validarRut()) {
                            System.out.println("El rut ingresado no es válido. Intente nuevamente.");
                        } else {
                            break;
                        }
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
                    System.out.print("Ingrese número de cuenta: ");
String numCuenta = scanner.nextLine();
                    System.out.print("Ingrese Tipo de cuenta (1=Corriente, 2=Ahorro, 3=Crédito): ");
int tipo = scanner.nextInt(); scanner.nextLine();
Cuenta cuenta;
switch (tipo) {
    case 1 -> cuenta = new CuentaCorriente(numCuenta);
    case 2 -> cuenta = new CuentaAhorro(numCuenta);
    case 3 -> cuenta = new CuentaCredito(numCuenta);
    default -> {
        System.out.println("Tipo no válido. Se asignará cuenta corriente por defecto.");
        cuenta = new CuentaCorriente(numCuenta);
    }
}
            
                    Cliente cliente = new Cliente(rut, nombre, apPat, apMat, dom, comuna, fono, cuenta);
                    clientes.add(cliente);
                    System.out.println("Cliente registrado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese Rut del cliente: ");
                    rut = scanner.nextLine();
                    Cliente c1 = clienteService.buscarClientePorRut(clientes, rut);
                    if (c1 != null) {
                        c1.mostrarDatos();
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese número de cuenta: ");
                    String numCuentaDep = scanner.nextLine();
                    Cliente c2 = clienteService.buscarClientePorCuenta(clientes, numCuentaDep);
                    if (c2 != null) {
                        System.out.print("Ingrese monto a depositar: ");
                        int monto = scanner.nextInt();
                        cuentaService.depositar(c2.getCuenta(), monto);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese número de cuenta: ");
                    String numCuentaGir = scanner.nextLine();
                    Cliente c3 = clienteService.buscarClientePorCuenta(clientes, numCuentaGir);
                    if (c3 != null) {
                        System.out.print("Ingrese monto a girar: ");
                        int monto = scanner.nextInt();
                        cuentaService.girar(c3.getCuenta(), monto);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese número de cuenta: ");
                    String numCuentaSal = scanner.nextLine();
                    Cliente c4 = clienteService.buscarClientePorCuenta(clientes, numCuentaSal);
                    if (c4 != null) {
                        cuentaService.consultarSaldo(c4.getCuenta());
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}
