package ejercicio1;

import java.util.Locale;

public class AnalizadorSentimientos {

    static class Comentario {
        String texto;

        public Comentario(String texto) {
            this.texto = texto;
        }
    }

    public static String analizarSentimiento(String texto) {
        String lowerText = texto.toLowerCase(Locale.ROOT);

        if (contienePalabraClave(lowerText,
                "feliz", "happy", "heureux", "alegre", "contento", "joyeux", "joyful",
                "encantado", "encantada", "delighted", "satisfecho", "satisfecha", "satisfied")) {
            return "positivo";
        } else if (contienePalabraClave(lowerText,
                "triste", "sad", "triste", "infeliz", "unhappy", "malheureux", "melancólico",
                "melancólica", "depressed", "abatido", "abatida", "downhearted")) {
            return "negativo";
        } else {
            return "neutral";
        }
    }

    private static boolean contienePalabraClave(String texto, String... palabrasClave) {
        for (String palabraClave : palabrasClave) {
            if (texto.contains(palabraClave)) {
                return true;
            }
        }
        return false;
    }

    public static void analizarComentarios(Comentario[] comentarios) {
        int positivos = 0;
        int negativos = 0;
        int neutrales = 0;

        for (Comentario comentario : comentarios) {
            String sentimiento = analizarSentimiento(comentario.texto);
            System.out.println("Comentario: " + comentario.texto + " - Sentimiento: " + sentimiento);


            if (sentimiento.equals("positivo")) {
                positivos++;
            } else if (sentimiento.equals("negativo")) {
                negativos++;
            } else {
                neutrales++;
            }
        }


        System.out.println("Resumen:");
        System.out.println("Comentarios Positivos: " + positivos);
        System.out.println("Comentarios Negativos: " + negativos);
        System.out.println("Comentarios Neutrales: " + neutrales);
    }

    public static void main(String[] args) {
        Comentario[] comentarios = {
                new Comentario("Hoy es un gran día."),
                new Comentario("No me siento bien."),
                new Comentario("Disfrutando de las vacaciones."),
                new Comentario("I am feeling happy."),
                new Comentario("Je suis triste."),
                new Comentario("Feeling joyful and content."),
                new Comentario("Je me sens malheureux et triste."),
                new Comentario("Estoy encantado con los resultados."),
                new Comentario("Me siento abatido por la noticia."),
                new Comentario("Feeling satisfied and delighted.")
        };

        analizarComentarios(comentarios);
    }
}

