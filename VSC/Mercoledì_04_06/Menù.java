package Private;

import java.util.ArrayList;
import java.util.Scanner;

class Utente {
    String nome;
    String cognome;
    String telefono;

    public Utente(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public String toString() {
        return nome + " " + cognome + " (" + telefono + ")";
    }
}

class PiattoSpeciale {
    public String tipoPanino;
    private String tipoHamburger;
    private double prezzoHamburger;

    private static final String[] OPZIONI_HAMBURGER = {"Manzo", "Vegetariano"};
    private static final double[] PREZZI_HAMBURGER = {2.0, 3.0};

    private static final String[] INGREDIENTI_PRIVATI = {
        "Pomodoro", "Mozzarella", "Insalata", "Salsa BBQ", "Cipolla"
    };
    private static final double[] PREZZI_INGREDIENTI = {
        0.50, 1.00, 0.30, 0.70, 0.40
    };

    private ArrayList<String> ingredientiSelezionati = new ArrayList<>();
    private ArrayList<Double> prezziSelezionati = new ArrayList<>();

    private static final double PREZZO_BASE = 1.0;

    public void mostraHamburger() {
        System.out.println("Scegli il tipo di hamburger:");
        for (int i = 0; i < OPZIONI_HAMBURGER.length; i++) {
            System.out.printf("%d. %s (%.2f EURO)%n", i + 1, OPZIONI_HAMBURGER[i], PREZZI_HAMBURGER[i]);
        }
    }

    public void setTipoHamburger(int scelta) {
        if (scelta >= 1 && scelta <= OPZIONI_HAMBURGER.length) {
            tipoHamburger = OPZIONI_HAMBURGER[scelta - 1];
            prezzoHamburger = PREZZI_HAMBURGER[scelta - 1];
        } else {
            tipoHamburger = OPZIONI_HAMBURGER[0];
            prezzoHamburger = PREZZI_HAMBURGER[0];
            System.out.println("Scelta non valida. Impostato hamburger di default: Manzo.");
        }
    }

    public void mostraIngredientiDisponibili() {
        System.out.println("Ingredienti disponibili:");
        for (int i = 0; i < INGREDIENTI_PRIVATI.length; i++) {
            double prezzo = PREZZI_INGREDIENTI[i] + 1.0;
            System.out.printf("%d. %s (%.2f EURO)%n", i + 1, INGREDIENTI_PRIVATI[i], prezzo);
        }
    }

    public void aggiungiIngrediente(int indice) {
        if (indice >= 1 && indice <= INGREDIENTI_PRIVATI.length) {
            String ingr = INGREDIENTI_PRIVATI[indice - 1];
            if (!ingredientiSelezionati.contains(ingr)) {
                ingredientiSelezionati.add(ingr);
                prezziSelezionati.add(PREZZI_INGREDIENTI[indice - 1] + 1.0);
            } else {
                System.out.println("Ingrediente già selezionato: " + ingr);
            }
        } else {
            System.out.println("Indice non valido.");
        }
    }

    public double calcolaTotale() {
        double totale = PREZZO_BASE + prezzoHamburger;
        for (double prezzo : prezziSelezionati) {
            totale += prezzo;
        }
        return totale;
    }

    public void stampaRiepilogo(Utente utente) {
        System.out.println("\n--- Riepilogo Ordine ---");
        System.out.println("Cliente: " + utente);
        System.out.println("Tipo di panino: " + tipoPanino + " (1.00 EURO)");
        System.out.println("Tipo di hamburger: " + tipoHamburger + " (" + prezzoHamburger + " EURO)");
        System.out.println("Ingredienti selezionati:");
        for (int i = 0; i < ingredientiSelezionati.size(); i++) {
            System.out.printf("- %s: %.2f EURO%n", ingredientiSelezionati.get(i), prezziSelezionati.get(i));
        }
        System.out.printf("Totale: %.2f EURO%n", calcolaTotale());
        System.out.println("__________________________\n");
    }

    public void reset() {
        tipoPanino = "";
        tipoHamburger = "";
        prezzoHamburger = 0.0;
        ingredientiSelezionati.clear();
        prezziSelezionati.clear();
    }
}

public class Menù {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Utente> utenti = new ArrayList<>();

        // Inserimento utente
        System.out.println("Registrazione utente:");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Cognome: ");
        String cognome = input.nextLine();
        System.out.print("Telefono: ");
        String telefono = input.nextLine();

        Utente utente = new Utente(nome, cognome, telefono);
        utenti.add(utente);

        PiattoSpeciale piatto = new PiattoSpeciale();

        while (true) {
            piatto.reset();
            System.out.println("\nBenvenuto nel menu del Piatto Speciale!");

            System.out.print("Scegli tipo di panino (es. normale, sesamo, integrale): ");
            piatto.tipoPanino = input.nextLine();

            piatto.mostraHamburger();
            System.out.print("Numero hamburger: ");
            int sceltaHamb = input.nextInt();
            input.nextLine();
            piatto.setTipoHamburger(sceltaHamb);

            piatto.mostraIngredientiDisponibili();
            System.out.println("Inserisci numeri ingredienti (0 per terminare):");
            while (true) {
                System.out.print("Ingrediente n°: ");
                int scelta = input.nextInt();
                if (scelta == 0) break;
                piatto.aggiungiIngrediente(scelta);
            }
            input.nextLine();

            piatto.stampaRiepilogo(utente);

            System.out.print("Vuoi fare un altro ordine? (s/n): ");
            String risposta = input.nextLine();
            if (!risposta.equalsIgnoreCase("s")) break;
        }

        System.out.println("Grazie per aver ordinato!");
        input.close();
    }
}

