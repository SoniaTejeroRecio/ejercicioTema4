package ejercicio3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de análisis de tendencias en redes sociales.");
        List<String> datos = generarDatosRedesSociales(100); // Generar 100 datos
        analizarTendencias(datos);
    }

    public static List<String> generarDatosRedesSociales(int cantidadDatos) {
        List<String> datos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidadDatos; i++) {
            String tema = "Tema" + (i + 1);
            String hashtag1 = "#hashtag" + random.nextInt(10); // Ajustado a 10 hashtags
            String hashtag2 = "#evento" + random.nextInt(10); // Ajustado a 10 eventos

            //Generamos datos aleatorios
            String dato = tema + " " + hashtag1 + " " + hashtag2;
            datos.add(dato);
        }

        return datos;
    }

    public static void analizarTendencias(List<String> datos) {
        Map<String, Integer> tendencias = identificarTendencias(datos);

        System.out.println("Tendencias actuales:");

        for (Map.Entry<String, Integer> entry : tendencias.entrySet()) {
            String tendencia = entry.getKey();
            int frecuencia = entry.getValue();

            System.out.println("Tendencia: " + tendencia + " - Frecuencia: " + frecuencia);
        }
    }

    public static Map<String, Integer> identificarTendencias(List<String> datos) {
        Map<String, Integer> tendencias = new HashMap<>();

        for (String dato : datos) {
            String[] palabras = dato.split("\\s+");

            for (String palabra : palabras) {

                if (palabra.startsWith("#")) {

                    String tendencia = limpiarTendencia(palabra);


                    tendencias.put(tendencia, tendencias.getOrDefault(tendencia, 0) + 1);
                }
            }
        }

        return tendencias;
    }

    private static String limpiarTendencia(String palabra) {
        //Eliminación de caracteres
        return palabra.replaceAll("[^a-zA-Z0-9]", "");
    }
}
