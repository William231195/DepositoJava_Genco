import java.util.ArrayList;

public class FlottaAerea {

    public static void main(String[] args) {
        // Crea una compagnia aerea con nome "LUFTHANSA"
        CompagniaAerea compagnia = new CompagniaAerea("LUFTHANSA");

        // Aggiunta di 10 aerei alla flotta
        compagnia.aggiungiAereo(new Aereo("Boeing 737", 180, "VX123"));
        compagnia.aggiungiAereo(new Aereo("Airbus A320", 150, "VX456"));
        compagnia.aggiungiAereo(new Aereo("Embraer 190", 100, "VX789"));
        compagnia.aggiungiAereo(new Aereo("Boeing 777", 300, "VX321"));
        compagnia.aggiungiAereo(new Aereo("Airbus A380", 500, "VX654"));
        compagnia.aggiungiAereo(new Aereo("ATR 72", 70, "VX987"));
        compagnia.aggiungiAereo(new Aereo("Bombardier CRJ900", 90, "VX741"));
        compagnia.aggiungiAereo(new Aereo("Boeing 787", 280, "VX852"));
        compagnia.aggiungiAereo(new Aereo("Airbus A350", 325, "VX963"));
        compagnia.aggiungiAereo(new Aereo("McDonnell Douglas MD-80", 155, "VX159"));

        // Aggiunta di 10 piloti
        compagnia.aggiungiPilota(new Pilota("Mario Rossi", "BR123", 1325));
        compagnia.aggiungiPilota(new Pilota("Anna Bianchi", "BR456", 885));
        compagnia.aggiungiPilota(new Pilota("Luigi Verdi", "BR789", 1500));
        compagnia.aggiungiPilota(new Pilota("Sara Neri", "BR101", 920));
        compagnia.aggiungiPilota(new Pilota("Luca Gialli", "BR102", 600));
        compagnia.aggiungiPilota(new Pilota("Giulia Blu", "BR103", 1100));
        compagnia.aggiungiPilota(new Pilota("Marco Arancio", "BR104", 300));
        compagnia.aggiungiPilota(new Pilota("Elena Viola", "BR105", 100));
        compagnia.aggiungiPilota(new Pilota("Francesco Bianco", "BR106", 750));
        compagnia.aggiungiPilota(new Pilota("Laura Grigia", "BR107", 1600));

        // Stampa tutti i dettagli (aerei e piloti)
        compagnia.stampaDettagli();

        // Filtro: mostra solo gli aerei con almeno 200 posti
        compagnia.cercaAereiPerPosti(200);

        // Filtro: mostra solo i piloti con almeno 500 ore di volo
        compagnia.cercaPilotiEsperti(500);

        // Filtro: mostra solo gli aerei che nel modello contengono "Boeing"
        compagnia.cercaAereiPerModello("Boeing");

        // Filtro: mostra solo i piloti che nel nome contengono "Giulia"
        compagnia.cercaPilotiPerNome("Giulia");
    }
}

// =============================
// CLASSE AEREO
// =============================
class Aereo {
    private String modello;       // modello dell’aereo (es. "Boeing 737")
    private int numeroPosti;      // numero di posti disponibili
    private String codice;        // codice identificativo dell’aereo

    // Costruttore
    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codice = codice;
    }

    // Metodi getter
    public String getModello() {
        return modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public String getCodice() {
        return codice;
    }

    // Rappresentazione testuale dell’aereo
    public String toString() {
        return "Aereo: " + modello + " | Codice: " + codice + " | Posti: " + numeroPosti;
    }
}

// =============================
// CLASSE PILOTA
// =============================
class Pilota {
    private String nome;             // nome del pilota
    private String numeroBrevetto;   // codice brevetto
    private int oreVolo;             // ore di volo accumulate

    // Costruttore
    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;
    }

    // Metodi getter
    public String getNome() {
        return nome;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    // Rappresentazione testuale del pilota
    public String toString() {
        return "Pilota: " + nome + " | Brevetto: " + numeroBrevetto + " | Ore di volo: " + oreVolo;
    }
}

// =============================
// CLASSE COMPAGNIA AEREA
// =============================
class CompagniaAerea {
    private String nome;                 // nome della compagnia
    private ArrayList<Aereo> flotta;    // lista degli aerei
    private ArrayList<Pilota> piloti;   // lista dei piloti

    // Costruttore
    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    // Aggiunta di un aereo alla flotta
    public void aggiungiAereo(Aereo a) {
        flotta.add(a);
    }

    // Aggiunta di un pilota all’elenco
    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }

    // Stampa tutte le informazioni della compagnia
    public void stampaDettagli() {
        System.out.println("Compagnia Aerea: " + nome);

        System.out.println("\n--- Flotta ---");
        for (Aereo a : flotta) {
            System.out.println(a);
        }

        System.out.println("\n--- Piloti ---");
        for (Pilota p : piloti) {
            System.out.println(p);
        }
    }

    // Filtro 1: aerei con almeno un numero minimo di posti
    public void cercaAereiPerPosti(int minimoPosti) {
        System.out.println("\n Aerei con almeno " + minimoPosti + " posti:");
        for (Aereo a : flotta) {
            if (a.getNumeroPosti() >= minimoPosti) {
                System.out.println(a);
            }
        }
    }

    // Filtro 2: piloti con almeno un numero minimo di ore di volo
    public void cercaPilotiEsperti(int minimoOre) {
        System.out.println("\n Piloti con almeno " + minimoOre + " ore di volo:");
        for (Pilota p : piloti) {
            if (p.getOreVolo() >= minimoOre) {
                System.out.println(p);
            }
        }
    }

    // Filtro 3: cerca aerei per parola chiave nel modello
    public void cercaAereiPerModello(String parolaChiave) {
        System.out.println("\n Aerei con modello contenente \"" + parolaChiave + "\":");
        for (Aereo a : flotta) {
            if (a.getModello().toLowerCase().contains(parolaChiave.toLowerCase())) {
                System.out.println(a);
            }
        }
    }

    // Filtro 4: cerca piloti per parola chiave nel nome
    public void cercaPilotiPerNome(String nomeCercato) {
        System.out.println("\n Piloti con nome contenente \"" + nomeCercato + "\":");
        for (Pilota p : piloti) {
            if (p.getNome().toLowerCase().contains(nomeCercato.toLowerCase())) {
                System.out.println(p);
            }
        }
    }
}
