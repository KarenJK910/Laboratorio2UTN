package Principal;

public abstract class Empleado {
    private String nombre;
    private int id;
    private double sueldoBase;

    public Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    // Método abstracto para calcular el sueldo
    public abstract double calcularSueldo();

}
