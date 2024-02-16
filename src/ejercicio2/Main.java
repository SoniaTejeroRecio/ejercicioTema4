package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

//clases
class ConfiguracionRed {
    private int cantidadRouters;
    private int cantidadSwitches;

    public ConfiguracionRed(int cantidadRouters, int cantidadSwitches) {
        this.cantidadRouters = cantidadRouters;
        this.cantidadSwitches = cantidadSwitches;
    }

    public int getCantidadRouters() {
        return cantidadRouters;
    }

    public int getCantidadSwitches() {
        return cantidadSwitches;
    }
}

class TraficoRed {
    private String origen;
    private String destino;
    private int cantidadDatos;

    public TraficoRed(String origen, String destino, int cantidadDatos) {
        this.origen = origen;
        this.destino = destino;
        this.cantidadDatos = cantidadDatos;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCantidadDatos() {
        return cantidadDatos;
    }
}

class CuelloBotella {
    private String ubicacion;

    public CuelloBotella(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}

class Dispositivo {
    private String nombre;

    public Dispositivo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Red {
    private ArrayList<Dispositivo> dispositivos;

    public Red(int cantidadRouters, int cantidadSwitches) {
        this.dispositivos = new ArrayList<>();

        for (int i = 0; i < cantidadRouters; i++) {
            dispositivos.add(new Dispositivo("Router" + i));
        }
        for (int i = 0; i < cantidadSwitches; i++) {
            dispositivos.add(new Dispositivo("Switch" + i));
        }
    }

    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("MENÚ PRINCIPAL");
        ConfiguracionRed configuracion = obtenerConfiguracionUsuario();
        simularRed(configuracion);
    }

    public static ConfiguracionRed obtenerConfiguracionUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número de routers: ");
        int cantidadRouters = scanner.nextInt();

        System.out.print("Número de switches: ");
        int cantidadSwitches = scanner.nextInt();

        return new ConfiguracionRed(cantidadRouters, cantidadSwitches);
    }

    public static Red crearRed(ConfiguracionRed configuracion) {
        return new Red(configuracion.getCantidadRouters(), configuracion.getCantidadSwitches());
    }

    public static void simularRed(ConfiguracionRed configuracion) {
        Red red = crearRed(configuracion);
        ArrayList<TraficoRed> trafico = simularTrafico(red);
        ArrayList<CuelloBotella> cuellosDeBotella = identificarCuellosDeBotella(trafico);
        mostrarResultados(cuellosDeBotella);
    }

    public static ArrayList<TraficoRed> simularTrafico(Red red) {
        ArrayList<TraficoRed> trafico = new ArrayList<>();
        ArrayList<Dispositivo> dispositivos = red.getDispositivos();

        for (int i = 0; i < dispositivos.size(); i++) {
            for (int j = 0; j < dispositivos.size(); j++) {
                if (i != j) {
                    String origen = dispositivos.get(i).getNombre();
                    String destino = dispositivos.get(j).getNombre();
                    int cantidadDatos = (int) (Math.random() * 1000);
                    trafico.add(new TraficoRed(origen, destino, cantidadDatos));
                }
            }
        }

        return trafico;
    }

    public static ArrayList<CuelloBotella> identificarCuellosDeBotella(ArrayList<TraficoRed> trafico) {
        ArrayList<CuelloBotella> cuellosDeBotella = new ArrayList<>();

        int maxDatos = -1;
        String ubicacion = "";

        for (TraficoRed datos : trafico) {
            if (datos.getCantidadDatos() > maxDatos) {
                maxDatos = datos.getCantidadDatos();
                ubicacion = datos.getOrigen() + " -> " + datos.getDestino();
            }
        }

        if (maxDatos > 0) {
            cuellosDeBotella.add(new CuelloBotella(ubicacion));
        }

        return cuellosDeBotella;
    }

    public static void mostrarResultados(ArrayList<CuelloBotella> cuellosDeBotella) {
        System.out.println("Resultados de la simulación:");
        for (CuelloBotella cuello : cuellosDeBotella) {
            System.out.println("Cuello de botella en: " + cuello.getUbicacion());
        }
    }
}




