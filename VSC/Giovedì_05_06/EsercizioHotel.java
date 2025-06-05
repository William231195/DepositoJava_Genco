import java.util.ArrayList;

// Classe base Camera
class Camera {
    private int numero;
    private float prezzo;

    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    // Inizio Getter e Setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    } // Fine Getter e Setter

    // Metodo dettagli senza parametri
    public void dettagli() {
        System.out.println("Camera n° " + numero + ", Prezzo: " + prezzo + " EURO");
    }

    // Overload con parametro
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            System.out.println("Camera n° " + numero + ", Prezzo: " + prezzo + " EURO");
        } else {
            System.out.println("Camera n° " + numero);
        }
    }
}

// Sottoclasse Suite
class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }

    public String getServiziExtra() {
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    // Override di dettagli
    @Override
    public void dettagli() {
        System.out.println("Suite n° " + getNumero() + ", Prezzo: " + getPrezzo() + " EURO, Extra: " + serviziExtra);
    }
}

// Classe Hotel
class Hotel {
    private String nome;
    private ArrayList<Camera> camere;

    public Hotel(String nome) {
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    public void aggiungiCamera(Camera c) {
        camere.add(c);
    }

    public void stampaCamere() {
        for (Camera c : camere) {
            c.dettagli();
        }
    }

    // Metodo statico
    public static int contaSuite(ArrayList<Camera> lista) {
        int count = 0;
        for (Camera c : lista) {
            if (c instanceof Suite) {  // Controlla se è una Suite (di una sottoclasse di Camera)
                count++;
            }
        }
        return count;
    }

    public ArrayList<Camera> getCamere() {
        return camere;
    }
}

// Classe Main
public class EsercizioHotel {
    public static void main(String[] args) {
        // Crea hotel
        Hotel hotel = new Hotel("Zack & Cody al Grand Hotel");

        // Aggiungi 2 camere normali
        Camera c1 = new Camera(121, 95.0f);
        Camera c2 = new Camera(142, 75.0f);
        hotel.aggiungiCamera(c1);
        hotel.aggiungiCamera(c2);

        // Aggiungi 2 suite
        Suite s1 = new Suite(201, 150.0f, "Idromassaggio, Frigobar");
        Suite s2 = new Suite(202, 190.0f, "Stanza del sale, Sauna");
        hotel.aggiungiCamera(s1);
        hotel.aggiungiCamera(s2);

        // Usa overload
        System.out.println("\n-- Dettagli camere con overload --");
        c1.dettagli();
        c2.dettagli(false);
        s1.dettagli(); // override

        // Metodo statico
        int numeroSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("\nNumero di suite presenti: " + numeroSuite);

        // Stampa completa
        System.out.println("\n-- Tutte le camere in hotel --");
        hotel.stampaCamere();
    }
}
