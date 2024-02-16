package ejercico11;

import java.util.Scanner;

public class GeneradorPatronesASCII {

    public static void main(String[] args) {
        char tipo = obtenerTipoPatron();
        int tamaño = obtenerTamaño();
        char caracter = obtenerCaracter();

        generarPatronASCII(tipo, tamaño, caracter);
    }

    public static char obtenerTipoPatron() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de patrón (r para rectángulo, t para triángulo, d para rombo): ");
        return scanner.next().charAt(0);
    }

    public static int obtenerTamaño() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del patrón: ");
        return scanner.nextInt();
    }

    public static char obtenerCaracter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el carácter para el patrón: ");
        return scanner.next().charAt(0);
    }

    public static void generarPatronASCII(char tipo, int tamaño, char caracter) {
        switch (tipo) {
            case 'r':
                generarRectangulo(tamaño, tamaño, caracter);
                break;
            case 't':
                generarTriangulo(tamaño, caracter);
                break;
            case 'd':
                generarRombo(tamaño, caracter);
                break;
            default:
                System.out.println("Tipo de patrón no válido.");
        }
    }

    public static void generarRectangulo(int filas, int columnas, char caracter) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    public static void generarTriangulo(int altura, char caracter) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    public static void generarRombo(int altura, char caracter) {
        for (int i = 0; i < altura; i++) {
            for (int j = altura - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(caracter);
            }
            for (int l = 0; l < i; l++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
        for (int i = altura - 2; i >= 0; i--) {
            for (int j = altura - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(caracter);
            }
            for (int l = 0; l < i; l++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }
}
