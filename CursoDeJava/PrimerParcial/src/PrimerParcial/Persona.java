package PrimerParcial;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class Persona {
    private String nombre;
    private String dni;
    private Date fechaNacimiento;

    public Persona(String nombre, String dni, String fechaNacimiento) throws ParseException {
        this.nombre = nombre;
        this.dni = dni;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaNacimiento = dateFormat.parse(fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
}
