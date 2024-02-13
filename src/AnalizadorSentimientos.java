import java.util.Locale;

public class AnalizadorSentimientos {

    static class Publicacion { //clase publicación
        String texto;

        public Publicacion(String texto) {
            this.texto = texto;
        }
    }


    public static String analizarSentimiento(String texto) {
        String lowerText = texto.toLowerCase(Locale.ROOT); //transformamos los textos a minúsculos
        //hacemos eso ya que si el texto se encuentra en mayúsculas, no van a encajar con las palabras clave definidas posteriormente y nos puede dar un resultado equivocado

        //Palabras clave de sentimientos (en distintos idiomas)
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

    //función que comprueba si el texto a estudiar, presenta alguna de las plabras clave anteriormente definidas
    private static boolean contienePalabraClave(String texto, String... palabrasClave) {
        for (String palabraClave : palabrasClave) {
            if (texto.contains(palabraClave)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        //ejemplos de publicaciones en varios idiomas
        Publicacion[] publicaciones = {
                new Publicacion("Hoy es un gran día."),
                new Publicacion("No me siento bien."),
                new Publicacion("Disfrutando de las vacaciones."),
                new Publicacion("I am feeling happy."),
                new Publicacion("Je suis triste."),
                new Publicacion("Feeling joyful and content."),
                new Publicacion("Je me sens malheureux et triste."),
                new Publicacion("Estoy encantado con los resultados."),
                new Publicacion("Me siento abatido por la noticia."),
                new Publicacion("Feeling satisfied and delighted.")
        };

        //llama a la función: "analizarSentimiento y analiza de que tipo de seintimineto se trata y si es: positivo, neutro o negativo y posterirmente lo immprime por pantalla
        for (Publicacion publicacion : publicaciones) {
            String sentimiento = analizarSentimiento(publicacion.texto);
            System.out.println("Publicación: " + publicacion.texto + " - Sentimiento: " + sentimiento);
        }
    }
}
