package PrimerParcial;
import java.text.ParseException;
class Doctor extends Persona {
    private String especialidad;

    public Doctor(String nombre, String dni, String fechaNacimiento, String especialidad) throws ParseException {
        super(nombre, dni, fechaNacimiento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}


