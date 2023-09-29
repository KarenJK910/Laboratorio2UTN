package PrimerParcial;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class HospitalSistema {
    private static List<Doctor> doctores = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static String datosContactoHospital = "datos.txt";

    public static void main(String[] args) {
        cargarDoctoresIniciales();
        cargarDatosContactoHospital();
        mostrarMenu();
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
            System.out.println("Menú:");
            System.out.println("1. Listar Doctores.");
            System.out.println("2. Registrar un nuevo paciente.");
            System.out.println("3. Consultar el historial médico de un paciente.");
            System.out.println("4. Nuevo historial para un paciente.");
            System.out.println("5. Cargar datos de contacto del Hospital desde Archivo de Texto.");
            System.out.println("6. Guardado y Recuperación de información de los pacientes.");
            System.out.println("7. Salir.");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarDoctores();
                    break;
                case 2:
                    registrarNuevoPaciente(scanner);
                    break;
                case 3:
                    consultarHistorialMedico(scanner);
                    break;
                case 4:
                    cargarNuevoHistorialMedico(scanner);
                    break;
                case 5:
                    cargarDatosContactoHospital();
                    break;
                case 6:
                    guardarRecuperarInformacionPacientes();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void listarDoctores() {
        System.out.println("Lista de Doctores:");
        for (Doctor doctor : doctores) {
            System.out.println("Nombre: " + doctor.getNombre());
            System.out.println("DNI: " + doctor.getDni());
            System.out.println("Fecha de Nacimiento: " + new SimpleDateFormat("dd/MM/yyyy").format(doctor.getFechaNacimiento()));
            System.out.println("Especialidad: " + doctor.getEspecialidad());
            System.out.println();
        }
    }

    private static void registrarNuevoPaciente(Scanner scanner) {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del paciente: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del paciente (dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono del paciente: ");
        String numeroTelefono = scanner.nextLine();
        System.out.print("Ingrese el tipo de sangre del paciente: ");
        int tipoSangre = scanner.nextInt();
        scanner.nextLine();

        try {
            Paciente paciente = new Paciente(nombre, dni, fechaNacimiento, numeroTelefono, tipoSangre);
            pacientes.add(paciente);
            System.out.println("Paciente registrado exitosamente.");
        } catch (ParseException e) {
            System.out.println("Error al registrar al paciente. Verifique el formato de fecha.");
        }
    }



    private static void consultarHistorialMedico(Scanner scanner) {
        System.out.print("Indique el DNI del paciente a buscar: ");
        String dniBuscar = scanner.nextLine();

        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dniBuscar)) {
                paciente.verHistorialDeEventos();
                return;
            }
        }

        System.out.println("No se encontró un paciente con el DNI especificado.");
    }

    private static void cargarNuevoHistorialMedico(Scanner scanner) {
        System.out.print("Indique el DNI del paciente al que se le quiere cargar un nuevo historial: ");
        String dniBuscar = scanner.nextLine();

        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dniBuscar)) {
                System.out.print("Ingrese la fecha del nuevo evento (dd/MM/yyyy): ");
                String fechaEvento = scanner.nextLine();
                System.out.print("Ingrese las observaciones del nuevo evento: ");
                String observaciones = scanner.nextLine();
                String nuevoEvento = fechaEvento + " - " + observaciones;
                paciente.agregarEventoHistorial(nuevoEvento);
                System.out.println("Historial médico actualizado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un paciente con el DNI especificado.");
    }

    private static void cargarDoctoresIniciales() {
        try {
            Doctor doctor1 = new Doctor("Juan Pérez", "12345678", "15/05/1980", "Cardiología");
            Doctor doctor2 = new Doctor("María López", "98765432", "25/03/1975", "Pediatría");

            doctores.add(doctor1);
            doctores.add(doctor2);
        } catch (ParseException e) {
            System.out.println("Error al cargar los doctores iniciales. Verifique el formato de fecha.");
        }
    }

    private static void cargarDatosContactoHospital() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C://Users//Usuario//Desktop//LAB2PP//Laboratorio2UTN//CursoDeJava//PrimerParcial//datos.txt"));
            StringBuilder datos = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                datos.append(linea).append("\n");
            }

            datosContactoHospital = datos.toString();
            br.close();
        } catch (IOException e) {
            System.out.println("No se pudo cargar la información de contacto del hospital desde el archivo.");
        }
    }

    private static void guardarRecuperarInformacionPacientes() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pacientes.dat"));
            oos.writeObject(pacientes);
            oos.close();
            System.out.println("Información de pacientes guardada exitosamente.");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pacientes.dat"));
            pacientes = (List<Paciente>) ois.readObject();
            ois.close();
            System.out.println("Información de pacientes recuperada exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar o recuperar la información de pacientes.");
        }
    }
}