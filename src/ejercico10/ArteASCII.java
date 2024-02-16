package ejercico10;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArteASCII {

    public static void main(String[] args) {
        try {
            String rutaImagen = obtenerRutaImagen();
            BufferedImage imagen = cargarImagen(rutaImagen);

            int ancho = obtenerAncho();
            int alto = obtenerAlto();

            String caracteres = obtenerCaracteres();

            String arteASCII = convertirAArteASCII(imagen, ancho, alto, caracteres);
            mostrarArte(arteASCII);
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    public static String obtenerRutaImagen() {
        //Esto es un ejemplo de ruta de una imagen
        return "ruta/a/tu/imagen.jpg";
    }

    public static BufferedImage cargarImagen(String ruta) throws IOException {
        return ImageIO.read(new File(ruta));
    }

    public static int obtenerAncho() {
        //Aquí irían las medidas
        return 80;
    }

    public static int obtenerAlto() {
        //Aquí irían las medidas
        return 40;
    }

    public static String obtenerCaracteres() {
        //Aquí irían los cracteres
        return "@%#*+=-:. ";
    }

    public static String convertirAArteASCII(BufferedImage imagen, int ancho, int alto, String caracteres) {
        StringBuilder arteASCII = new StringBuilder();

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int pixelColor = imagen.getRGB(x * imagen.getWidth() / ancho, y * imagen.getHeight() / alto);
                double luminancia = calcularLuminancia(pixelColor);
                char caracter = obtenerCaracter(luminancia, caracteres);
                arteASCII.append(caracter);
            }
            arteASCII.append("\n");
        }

        return arteASCII.toString();
    }

    public static double calcularLuminancia(int rgb) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
        return 0.299 * r + 0.587 * g + 0.114 * b;
    }

    public static char obtenerCaracter(double luminancia, String caracteres) {
        int indiceCaracter = (int) (luminancia / 255.0 * (caracteres.length() - 1));
        return caracteres.charAt(indiceCaracter);
    }

    public static void mostrarArte(String arteASCII) {
        System.out.println(arteASCII);
    }
}
