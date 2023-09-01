package Principal;

public class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        // Implementación de cálculo de sueldo para EmpleadoAsalariado
        return getSueldoBase();
    }
}
