package Principal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestorEmpleados = new GestorEmpleados();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Calcular sueldo e impuesto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar empleado
                    System.out.print("Nombre del empleado: ");
                    String nombre = scanner.next();
                    System.out.print("ID del empleado: ");
                    int id = scanner.nextInt();
                    System.out.print("Sueldo base del empleado: ");
                    double sueldoBase = scanner.nextDouble();
                    System.out.print("Tipo de empleado (1 - Por Horas, 2 - Asalariado, 3 - Comisión): ");
                    int tipoEmpleado = scanner.nextInt();

                    Empleado empleado = null;

                    switch (tipoEmpleado) {
                        case 1:
                            // Empleado por Horas
                            System.out.print("Horas trabajadas: ");
                            int horasTrabajadas = scanner.nextInt();
                            empleado = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                            break;
                        case 2:
                            // Empleado Asalariado
                            empleado = new EmpleadoAsalariado(nombre, id, sueldoBase);
                            break;
                        case 3:
                            // Empleado Comisión
                            System.out.print("Ventas realizadas: ");
                            double ventasRealizadas = scanner.nextDouble();
                            empleado = new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas);
                            break;
                        default:
                            System.out.println("Tipo de empleado no válido.");
                            break;
                    }

                    if (empleado != null) {
                        gestorEmpleados.agregarEmpleado(empleado);
                        System.out.println("Empleado agregado con éxito.");
                    }
                    break;
                /*case 2:
                    // Modificar empleado
                    System.out.print("Índice del empleado a modificar: ");
                    int indiceModificar = scanner.nextInt();
                    gestorEmpleados.listarEmpleados();
                    System.out.print("Nuevo nombre del empleado: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Nuevo ID del empleado: ");
                    int nuevoId = scanner.nextInt();
                    System.out.print("Nuevo sueldo base del empleado: ");
                    double nuevoSueldoBase = scanner.nextDouble();
                    Empleado empleadoModificado = null;

                    if (indiceModificar >= 0 && indiceModificar < gestorEmpleados.size()) {
                        Empleado empleadoExistente = gestorEmpleados.getEmpleado(indiceModificar);

                        if (empleadoExistente instanceof EmpleadoPorHoras) {
                            // Modificar Empleado por Horas
                            System.out.print("Nuevas horas trabajadas: ");
                            int nuevasHorasTrabajadas = scanner.nextInt();
                            empleadoModificado = new EmpleadoPorHoras(nuevoNombre, nuevoId, nuevoSueldoBase, nuevasHorasTrabajadas);
                        } else if (empleadoExistente instanceof EmpleadoAsalariado) {
                            // Modificar Empleado Asalariado
                            empleadoModificado = new EmpleadoAsalariado(nuevoNombre, nuevoId, nuevoSueldoBase);
                        } else if (empleadoExistente instanceof EmpleadoComision) {
                            // Modificar Empleado Comisión
                            System.out.print("Nuevas ventas realizadas: ");
                            double nuevasVentasRealizadas = scanner.nextDouble();
                            empleadoModificado = new EmpleadoComision(nuevoNombre, nuevoId, nuevoSueldoBase, nuevasVentasRealizadas);
                        }

                        if (empleadoModificado != null) {
                            gestorEmpleados.modificarEmpleado(indiceModificar, empleadoModificado);
                            System.out.println("Empleado modificado con éxito.");
                        }
                    } else {
                        System.out.println("Índice de empleado no válido.");
                    }
                    break;*/
                case 3:
                    // Eliminar empleado
                    System.out.print("Índice del empleado a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    gestorEmpleados.eliminarEmpleado(indiceEliminar);
                    System.out.println("Empleado eliminado con éxito.");
                    break;
                case 4:
                    // Listar empleados
                    gestorEmpleados.listarEmpleados();
                    break;
                case 5:
                    // Calcular sueldo e impuesto
                    System.out.print("Índice del empleado para calcular sueldo e impuesto: ");
                    int indiceCalcular = scanner.nextInt();
                    gestorEmpleados.calcularSueldoImpuesto(indiceCalcular);
                    break;
                case 6:
                    // Salir
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}