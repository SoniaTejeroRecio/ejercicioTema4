package ejercicio5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class DispositivoIoT {
    private String nombre;
    private double temperatura;
    private double humedad;
    private double calidadAire;

    public DispositivoIoT(String nombre) {
        this.nombre = nombre;
        this.temperatura = 0.0;
        this.humedad = 0.0;
        this.calidadAire = 0.0;
    }

    public void generarDatosAleatorios() {
        Random random = new Random();
        this.temperatura = 20 + random.nextDouble() * 15;
        this.humedad = 30 + random.nextDouble() * 40;
        this.calidadAire = random.nextDouble() * 100;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public double getCalidadAire() {
        return calidadAire;
    }
}

class SistemaMonitoreo {
    private List<DispositivoIoT> dispositivos;

    public SistemaMonitoreo() {
        this.dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(DispositivoIoT dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void monitorearAmbiente() {
        while (true) {
            Map<String, Map<String, Double>> datos = recolectarDatos();
            mostrarInterfazUsuario(datos);


            try {
                Thread.sleep(5000); //Esperamos5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, Map<String, Double>> recolectarDatos() {
        Map<String, Map<String, Double>> datos = new HashMap<>();

        for (DispositivoIoT dispositivo : dispositivos) {
            Map<String, Double> datosDispositivo = new HashMap<>();
            dispositivo.generarDatosAleatorios();

            datosDispositivo.put("Temperatura (°C)", dispositivo.getTemperatura());
            datosDispositivo.put("Humedad (%)", dispositivo.getHumedad());
            datosDispositivo.put("Calidad del Aire", dispositivo.getCalidadAire());

            datos.put(dispositivo.getNombre(), datosDispositivo);
        }

        return datos;
    }

    private void mostrarInterfazUsuario(Map<String, Map<String, Double>> datos) {
        System.out.println("Datos de Monitoreo Ambiental:");

        for (Map.Entry<String, Map<String, Double>> entry : datos.entrySet()) {
            String nombreDispositivo = entry.getKey();
            Map<String, Double> datosDispositivo = entry.getValue();

            System.out.println(nombreDispositivo + ":");
            for (Map.Entry<String, Double> dataEntry : datosDispositivo.entrySet()) {
                String tipoDato = dataEntry.getKey();
                Double valor = dataEntry.getValue();
                System.out.println("- " + tipoDato + ": " + valor);
            }
            System.out.println();
        }
    }
}

public class MonitoreoAmbiental {
    public static void main(String[] args) {
        System.out.println("Sistema de Monitoreo Ambiental con IoT");

        SistemaMonitoreo sistemaMonitoreo = new SistemaMonitoreo();
        sistemaMonitoreo.agregarDispositivo(new DispositivoIoT("Sensor1"));
        sistemaMonitoreo.agregarDispositivo(new DispositivoIoT("Sensor2"));

        sistemaMonitoreo.monitorearAmbiente();
    }
}
