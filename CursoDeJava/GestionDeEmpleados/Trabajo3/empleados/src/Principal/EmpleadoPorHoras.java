package Principal;

public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        // Implementación de cálculo de sueldo para EmpleadoPorHoras
        return getSueldoBase() * horasTrabajadas;
    }
}
