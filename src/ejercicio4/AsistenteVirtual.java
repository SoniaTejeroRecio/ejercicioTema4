package ejercicio4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AsistenteVirtual {

    private static final Map<String, String> RESPUESTAS_PREDETERMINADAS = new HashMap<>();

    static {
        RESPUESTAS_PREDETERMINADAS.put("hola", "¡Hola! ¿En qué puedo ayudarte?");
        RESPUESTAS_PREDETERMINADAS.put("cómo estás", "Estoy bien, gracias por preguntar.");
        RESPUESTAS_PREDETERMINADAS.put("adiós", "¡Hasta luego! Si necesitas ayuda, estaré aquí.");
        RESPUESTAS_PREDETERMINADAS.put("qué haces", "Estoy aquí para ayudarte. ¿En qué puedo asistirte?");
        RESPUESTAS_PREDETERMINADAS.put("hora", obtenerHoraActual());

    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al Asistente Virtual Inteligente.");

        while (true) {
            interactuarConUsuario();
        }
    }

    public static void interactuarConUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuario: ");
        String solicitud = obtenerSolicitudUsuario(scanner);
        String respuesta = procesarSolicitud(solicitud);

        System.out.println("Asistente: " + respuesta);
    }

    public static String obtenerSolicitudUsuario(Scanner scanner) {
        System.out.print("Ingrese su solicitud: ");
        return scanner.nextLine().toLowerCase();
    }

    public static String procesarSolicitud(String solicitud) {
        if (RESPUESTAS_PREDETERMINADAS.containsKey(solicitud)) {
            return RESPUESTAS_PREDETERMINADAS.get(solicitud);
        }


        if (solicitud.contains("gracias")) {
            return "¡De nada! Estoy aquí para ayudar.";
        } else if (solicitud.contains("tarea")) {
            return "Realizando una tarea. ¡Listo!";
        } else {
            return "Lo siento, no puedo procesar esa solicitud en este momento.";
        }
    }

    public static String obtenerHoraActual() {

        return "La hora actual es 12:00 PM";
    }
}

