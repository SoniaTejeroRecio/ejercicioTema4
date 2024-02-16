package ejercico6;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando sistema de detección de transacciones fraudulentas...");
        Transacciones ts = GeneradorTransaccionesAleatorias.generarColeccionTransacciones();
        DetectorTransaccionesFraudulentas detector = new DetectorTransaccionesFraudulentas(ts);
        detector.detectarFraude();
        System.out.println("Proceso de detección de fraudes completado.");
    }
}

class DetectorTransaccionesFraudulentas {
    private Transacciones ts;

    public DetectorTransaccionesFraudulentas(Transacciones ts) {
        this.ts = ts;
    }

    public void detectarFraude() {
        System.out.println("Iniciando detección de fraudes...");
        for (Transaccion t : this.ts.getTransacciones()) {
            if (t.getFraudu()) {
                t.marcarComoFraudulenta();
                System.out.println("Transacción fraudulenta detectada - ID: " + t.getId());
            }
        }
        System.out.println("Detección de fraudes finalizada.");
    }
}

class GeneradorTransaccionesAleatorias {
    public static Transacciones generarColeccionTransacciones() {
        Transacciones ts = new Transacciones();
        System.out.println("Generando transacciones aleatorias...");
        for (int i = 0; i < 15; i++) {
            boolean esFraudulenta = Math.random() < 0.2; // Ajusta la probabilidad de fraude según tus necesidades
            ts.addTransaccion(esFraudulenta, i, Math.random() * 5000, "Compra en línea", i + 100, i + 200);
        }
        System.out.println("Generación de transacciones completada.");
        return ts;
    }
}

class Transaccion {
    private boolean fraudu;
    private int id;
    private double importe;
    private String concepto;
    private int idOd;
    private int idBe;

    public Transaccion(boolean fraudu, int id, double importe, String concepto, int idOd, int idBe) {
        this.fraudu = fraudu;
        this.id = id;
        this.importe = importe;
        this.concepto = concepto;
        this.idOd = idOd;
        this.idBe = idBe;
    }

    public void marcarComoFraudulenta() {
        this.setFraudu(true);
    }

    public boolean getFraudu() {
        return isFraudu();
    }

    private boolean isFraudu() {
        return fraudu;
    }

    private void setFraudu(boolean fraudu) {
        this.fraudu = fraudu;
    }

    public int getId() {
        return id;
    }
}

class Transacciones {
    private ArrayList<Transaccion> transacciones;

    public Transacciones() {
        this.transacciones = new ArrayList<>();
    }

    public void addTransaccion(Transaccion t) {
        this.transacciones.add(t);
    }

    public void addTransaccion(boolean fraudu, int id, double importe, String concepto, int idOd, int idBe) {
        this.transacciones.add(new Transaccion(fraudu, id, importe, concepto, idOd, idBe));
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }
}
