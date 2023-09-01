package Principal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GestorEmpleados {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void modificarEmpleado(int indice, Empleado empleado) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.set(indice, empleado);
            System.out.println("Empleado modificado con éxito.");
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.remove(indice);
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    public void listarEmpleados() {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            System.out.println("Empleado #" + (i + 1) + ": " + empleado.getNombre());
        }
    }

    public void calcularSueldoImpuesto(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            Empleado empleado = empleados.get(indice);
            double sueldo = empleado.calcularSueldo();
            double impuesto = 0;

            if (empleado instanceof Impuesto) {
                Impuesto empleadoConImpuesto = (Impuesto) empleado;
                impuesto = empleadoConImpuesto.calcularImpuesto();
            }

            System.out.println("Nombre del empleado: " + empleado.getNombre());
            System.out.println("Sueldo: $" + sueldo);
            System.out.println("Impuesto a pagar: $" + impuesto);
        } else {
            System.out.println("Índice de empleado no válido.");


        }
    }
}
