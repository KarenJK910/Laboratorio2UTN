package PrimerParcial;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class Paciente extends Persona implements Informacion {
    private String numeroTelefono;
    private int tipoSangre;
    private List<String> historialMedico;

    public Paciente(String nombre, String dni, String fechaNacimiento, String numeroTelefono, int tipoSangre) throws ParseException {
        super(nombre, dni, fechaNacimiento);
        this.numeroTelefono = numeroTelefono;
        this.tipoSangre = tipoSangre;
        this.historialMedico = new ArrayList<>();
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void agregarEventoHistorial(String evento) {
        historialMedico.add(evento);
    }

    @Override
    public void verHistorialDeEventos() {
        if (historialMedico.isEmpty()) {
            System.out.println("El historial médico está vacío.");
        } else {
            System.out.println("HISTORIAL MÉDICO:");
            for (String evento : historialMedico) {
                System.out.println(evento);
            }
        }
    }
}