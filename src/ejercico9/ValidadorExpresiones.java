package ejercico9;
import java.util.Scanner;
import java.util.Stack;

public class ValidadorExpresiones {

    public static void main(String[] args) {
        System.out.println("Validador de Expresiones Matemáticas.");

        String expresion = obtenerExpresionUsuario();
        validarExpresion(expresion);
    }

    public static String obtenerExpresionUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la expresión matemática: ");
        return scanner.nextLine();
    }

    public static void validarExpresion(String expresion) {
        try {
            if (comprobarSintaxis(expresion)) {
                System.out.println("La expresión es válida.");
            } else {
                System.out.println("La expresión no es válida. Los paréntesis no están balanceados.");
            }
        } catch (Exception e) {
            System.out.println("Error en la expresión: " + e.getMessage());
        }
    }

    public static boolean comprobarSintaxis(String expresion) throws Exception {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (esCaracterDeApertura(caracter)) {
                pila.push(caracter);
            } else if (esCaracterDeCierre(caracter)) {
                if (pila.isEmpty() || !esParValido(pila.pop(), caracter)) {
                    return false;
                }
            }
        }

        if (!pila.isEmpty()) {
            throw new Exception("Paréntesis no cerrados correctamente.");
        }

        return true;
    }

    public static boolean esCaracterDeApertura(char caracter) {
        return caracter == '(' || caracter == '[' || caracter == '{';
    }

    public static boolean esCaracterDeCierre(char caracter) {
        return caracter == ')' || caracter == ']' || caracter == '}';
    }

    public static boolean esParValido(char abre, char cierra) {
        return (abre == '(' && cierra == ')') ||
                (abre == '[' && cierra == ']') ||
                (abre == '{' && cierra == '}');
    }
}

