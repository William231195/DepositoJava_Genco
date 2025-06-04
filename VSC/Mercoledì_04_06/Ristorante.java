import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Classe base: Utente
class Utente {
    protected String nome;
    protected String email;
    protected float soldi;

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.soldi = generaSoldi();
    }

    protected float generaSoldi() {
        return new Random().nextFloat() * 100;
    }

    public void stampaDati() {
        System.out.printf("Utente: %s | Email: %s | Credito: %.2f EURO%n", nome, email, soldi);
    }
}

// Sottoclasse Chef
class Chef extends Utente {
    public Chef(String nome, String email) {
        super(nome, email);
    }

    public void aggiungiPiatto(ArrayList<String> piatti, Scanner input) {
        System.out.print("Inserisci il nome del nuovo piatto: ");
        String nuovoPiatto = input.nextLine();
        piatti.add(nuovoPiatto);
        System.out.println("Piatto aggiunto con successo!");
    }
}

// Sottoclasse Critico
class Critico extends Utente {
    public Critico(String nome, String email) {
        super(nome, email);
    }

    public void valutaPiatto(ArrayList<String> piatti, ArrayList<Integer> voti, Scanner input) {
        if (piatti.isEmpty()) {
            System.out.println("Nessun piatto disponibile da valutare.");
            return;
        }

        System.out.println("Scegli un piatto da valutare:");
        for (int i = 0; i < piatti.size(); i++) {
            System.out.println((i + 1) + ". " + piatti.get(i));
        }

        System.out.print("Numero del piatto: ");
        int scelta = Integer.parseInt(input.nextLine());

        if (scelta >= 1 && scelta <= piatti.size()) {
            System.out.print("Inserisci un voto (1-10): ");
            int voto = Integer.parseInt(input.nextLine());
            voti.set(scelta - 1, voto);
            System.out.println("Valutazione aggiornata!");
        } else {
            System.out.println("Scelta non valida.");
        }
    }
}

// Classe principale avviabile: Main
public class Ristorante {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> piatti = new ArrayList<>();
        ArrayList<Integer> voti = new ArrayList<>();

        Utente utente = null;
        boolean continua = true;

        while (continua) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Crea Utente");
            System.out.println("2. Visualizza Profilo");
            System.out.println("3. Accedi come Chef");
            System.out.println("4. Accedi come Critico");
            System.out.println("5. Mostra Piatti e Voti");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");
            String scelta = input.nextLine();

            switch (scelta) {
                case "1":
                    System.out.print("Inserisci il nome: ");
                    String nome = input.nextLine();
                    System.out.print("Inserisci l'email: ");
                    String email = input.nextLine();
                    utente = new Utente(nome, email);
                    System.out.println("Utente creato.");
                    break;
                case "2":
                    if (utente != null) utente.stampaDati();
                    else System.out.println("Nessun utente creato.");
                    break;
                case "3":
                    if (utente != null) {
                        Chef chef = new Chef(utente.nome, utente.email);
                        chef.aggiungiPiatto(piatti, input);
                        voti.add(0);
                    } else {
                        System.out.println("Crea prima un utente.");
                    }
                    break;
                case "4":
                    if (utente != null) {
                        Critico critico = new Critico(utente.nome, utente.email);
                        critico.valutaPiatto(piatti, voti, input);
                    } else {
                        System.out.println("Crea prima un utente.");
                    }
                    break;
                case "5":
                    if (piatti.isEmpty()) {
                        System.out.println("Nessun piatto presente.");
                    } else {
                        System.out.println("Elenco Piatti:");
                        for (int i = 0; i < piatti.size(); i++) {
                            System.out.printf("- %s (Voto: %d)%n", piatti.get(i), voti.get(i));
                        }
                    }
                    break;
                case "6":
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        input.close();
        System.out.println("Arrivederci!");
    }
}
