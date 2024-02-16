package ejercico8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GeneradorCitasConContexto {

    private static final Map<String, List<String>> BASE_DE_DATOS_CITAS_CON_CONTEXTO = new HashMap<>();

    static {
        //Positivas
        List<String> citasPositivas = List.of(
                "Hoy es un buen día para comenzar algo nuevo.",
                "La actitud lo es todo. Mantén una actitud positiva y las cosas buenas sucederán.",
                "Cada día es una nueva oportunidad para cambiar tu vida.");

        //enfado
        List<String> citasDesafiantes = List.of(
                "Los desafíos son lo que hacen la vida interesante. Supéralos.",
                "Nunca sabrás cuán fuerte eres hasta que ser fuerte es tu única opción.",
                "No temas los desafíos. Están diseñados para hacerte más fuerte.");

        //motivacion
        List<String> citasMotivacionales = List.of(
                "El éxito no es la clave de la felicidad. La felicidad es la clave del éxito. Si amas lo que haces, tendrás éxito.",
                "La motivación nos impulsa a comenzar, el hábito nos mantiene avanzando.",
                "No cuentes los días, haz que los días cuenten.");

        BASE_DE_DATOS_CITAS_CON_CONTEXTO.put("positivo", citasPositivas);
        BASE_DE_DATOS_CITAS_CON_CONTEXTO.put("enfado", citasDesafiantes);
        BASE_DE_DATOS_CITAS_CON_CONTEXTO.put("motivacional", citasMotivacionales);
        // Puedes agregar más contextos y citas según sea necesario
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al Generador de Citas Inspiradoras con Contexto.");

        String contexto = obtenerContextoUsuario();
        generarCitaConContexto(contexto);
    }

    public static String obtenerContextoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su estado de ánimo o contexto (positivo, desafiante, motivacional, etc.): ");
        return scanner.nextLine().toLowerCase();
    }

    public static void generarCitaConContexto(String contexto) {
        if (BASE_DE_DATOS_CITAS_CON_CONTEXTO.containsKey(contexto)) {
            List<String> citasContexto = BASE_DE_DATOS_CITAS_CON_CONTEXTO.get(contexto);
            String cita = obtenerCitaAleatoria(citasContexto);
            System.out.println("Cita Inspiradora para " + contexto + ": " + cita);
        } else {
            System.out.println("Lo siento, no hay citas disponibles para el contexto proporcionado.");
        }
    }

    public static String obtenerCitaAleatoria(List<String> listaCitas) {
        Random random = new Random();
        return listaCitas.get(random.nextInt(listaCitas.size()));
    }
}
