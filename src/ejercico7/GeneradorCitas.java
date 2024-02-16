package ejercico7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GeneradorCitas {

    private static final Map<String, List<String>> BASE_DE_DATOS_CITAS = new HashMap<>();

    static {
        List<String> citasAutor4 = new ArrayList<>();
        citasAutor4.add("Haz hoy lo que otros no quieren, haz mañana lo que otros no pueden.");
        citasAutor4.add("No puedes cambiar el viento, pero puedes ajustar las velas.");
        citasAutor4.add("El éxito es la suma de pequeños esfuerzos repetidos día tras día.");

        List<String> citasAutor5 = new ArrayList<>();
        citasAutor5.add("La creatividad es la inteligencia divirtiéndose.");
        citasAutor5.add("Nuestra imaginación es el único límite para lo que podemos lograr.");
        citasAutor5.add("La única manera de hacer un gran trabajo es amar lo que haces.");

        BASE_DE_DATOS_CITAS.put("Autor4", citasAutor4);
        BASE_DE_DATOS_CITAS.put("Autor5", citasAutor5);

    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al Generador de Citas Inspiradoras.");

        while (true) {
            generarCita();
            esperarSolicitudNuevaCita();
        }
    }

    public static void generarCita() {
        String autor = obtenerAutorAleatorio();
        String cita = obtenerCitaAleatoria(autor);

        System.out.println("Cita Inspiradora de " + autor + ": " + cita);
    }

    public static String obtenerAutorAleatorio() {
        List<String> autores = new ArrayList<>(BASE_DE_DATOS_CITAS.keySet());
        Random random = new Random();
        return autores.get(random.nextInt(autores.size()));
    }

    public static String obtenerCitaAleatoria(String autor) {
        List<String> citasAutor = BASE_DE_DATOS_CITAS.get(autor);
        Random random = new Random();
        return citasAutor.get(random.nextInt(citasAutor.size()));
    }

    public static void esperarSolicitudNuevaCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Desea obtener otra cita? (Sí/No): ");
        String respuesta = scanner.nextLine().toLowerCase();

        if (!respuesta.equals("si")) {
            System.out.println("¡Hasta luego!");
            System.exit(0);
        }
    }
}
