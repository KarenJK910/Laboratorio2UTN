package Principal;

public class EmpleadoComision extends Empleado {
    private double ventasRealizadas;

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        // Implementación de cálculo de sueldo para EmpleadoComision
        return getSueldoBase() + (ventasRealizadas * 0.1); // Supongamos una comisión del 10%
    }
}
