🏦 Sistema Bancario Orientado a Objetos en Java
Este proyecto implementa un sistema bancario basado en los principios de Programación Orientada a Objetos (POO) en Java. Está diseñado como una simulación modular de cuentas bancarias y clientes, incorporando funcionalidades típicas de un banco como depósito, retiro, transferencias, consulta de saldo y más.

🧠 Principios de POO Aplicados
✅ Abstracción
Se define una clase abstracta Cuenta que contiene comportamiento genérico para distintos tipos de cuenta.

Interfaz IMostrable que abstrae la capacidad de mostrar información de distintos objetos (cliente, cuenta, etc.).

🧬 Herencia
Las clases CuentaAhorro, CuentaCorriente y CuentaCredito heredan de la clase abstracta Cuenta, reutilizando y especializando su funcionalidad.

🔁 Polimorfismo
Uso de sobreescritura (override) para redefinir el comportamiento del método retirar() en cada subclase según la lógica de negocio correspondiente.

Polimorfismo dinámico al operar sobre referencias del tipo Cuenta que pueden apuntar a cualquier subclase (CuentaAhorro, CuentaCorriente, etc.).

⚙️ Encapsulamiento
Atributos privados con métodos get y set para proteger el estado interno de los objetos (Cliente, Cuenta).

🏗️ Estructura del Proyecto
└── Main.java                 // Punto de entrada de la aplicación
Models
├── Cliente.java              // Clase con atributos personales y métodos de acceso
├── Cuenta.java               // Clase abstracta con métodos comunes de cuenta
├── CuentaAhorro.java         // Subclase que implementa intereses y límites de retiro
├── CuentaCorriente.java      // Subclase con gestión de sobregiro
├── CuentaCredito.java        // Subclase con lógica de deuda y pago
├── IMostrable.java           // Interfaz para mostrar información
Services
├── ClienteService.java       // Lógica de negocio relacionada a clientes
├── CuentaService.java        // Operaciones sobre cuentas (alta, baja, movimientos)
Views
├── Menu.java                 // Menú de interacción por consola

✨ Funcionalidades Clave
Crear y obtener datos Clientes
Crear y obtener datos de Gestión de Cuentas: 

