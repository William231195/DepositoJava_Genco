import java.util.ArrayList;
import java.util.Scanner;

// Classe base Animale
class Animale {
    protected String nome;
    protected int eta;
    protected boolean malato;

    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        this.malato = true; // ogni animale nasce malato per esempio
    }

    public void faiVerso() {
        System.out.println("Verso generico...");
    }

    public void stampaInfo() {
        System.out.print("Nome: " + nome + ", Età: " + eta + ", Verso: ");
        faiVerso();
        System.out.println("Stato salute: " + (malato ? "Malato" : "Sano"));
    }

    public void cura() {
        this.malato = false;
    }
}

class Cane extends Animale {
    public Cane(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Bau!");
    }
}

class Gatto extends Animale {
    public Gatto(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}

class Scimmia extends Animale {
    public Scimmia(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Uuh uuh aaah!");
    }
}

abstract class Lavoratore {
    protected String nome;

    public Lavoratore(String nome) {
        this.nome = nome;
    }

    public abstract void lavora(Zoo zoo, Scanner input);
}

class Veterinario extends Lavoratore {
    public Veterinario(String nome) {
        super(nome);
    }

    @Override
    public void lavora(Zoo zoo, Scanner input) {
        System.out.println("--- Cura Animali Malati ---");
        ArrayList<Animale> tutti = zoo.getTuttiGliAnimali();
        for (int i = 0; i < tutti.size(); i++) {
            Animale a = tutti.get(i);
            if (a.malato) {
                System.out.printf("%d. %s (malato)\n", i + 1, a.nome);
            }
        }

        System.out.print("Scegli numero dell'animale da curare: ");
        int scelta = Integer.parseInt(input.nextLine()) - 1;
        if (scelta >= 0 && scelta < tutti.size()) {
            tutti.get(scelta).cura();
            System.out.println("Animale curato!");
        } else {
            System.out.println("Scelta non valida.");
        }
    }
}

class Zookeper extends Lavoratore {
    public Zookeper(String nome) {
        super(nome);
    }

    @Override
    public void lavora(Zoo zoo, Scanner input) {
        System.out.println("--- Aggiungi nuovo animale ---");
        System.out.print("Tipo (cane/gatto/scimmia): ");
        String tipo = input.nextLine().toLowerCase();
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Età: ");
        int eta = Integer.parseInt(input.nextLine());

        switch (tipo) {
            case "cane":
                zoo.aggiungiCane(new Cane(nome, eta));
                break;
            case "gatto":
                zoo.aggiungiGatto(new Gatto(nome, eta));
                break;
            case "scimmia":
                zoo.aggiungiScimmia(new Scimmia(nome, eta));
                break;
            default:
                System.out.println("Tipo non valido.");
        }
    }
}

class Zoo {
    ArrayList<Cane> cani = new ArrayList<>();
    ArrayList<Gatto> gatti = new ArrayList<>();
    ArrayList<Scimmia> scimmie = new ArrayList<>();

    public void aggiungiCane(Cane c) {
        cani.add(c);
    }

    public void aggiungiGatto(Gatto g) {
        gatti.add(g);
    }

    public void aggiungiScimmia(Scimmia s) {
        scimmie.add(s);
    }

    public ArrayList<Animale> getTuttiGliAnimali() {
        ArrayList<Animale> tutti = new ArrayList<>();
        tutti.addAll(cani);
        tutti.addAll(gatti);
        tutti.addAll(scimmie);
        return tutti;
    }

    public void stampaTutti() {
        System.out.println("=== Cani ===");
        for (Cane c : cani) c.stampaInfo();
        System.out.println("=== Gatti ===");
        for (Gatto g : gatti) g.stampaInfo();
        System.out.println("=== Scimmie ===");
        for (Scimmia s : scimmie) s.stampaInfo();
    }
}

// Classe Main
public class Animali {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Zoo zoo = new Zoo();

        Lavoratore vet = new Veterinario("Dottore Rossi");
        Lavoratore keeper = new Zookeper("Sig. Bianchi");

        boolean attivo = true;
        while (attivo) {
            System.out.println("\n=== MENU ZOO ===");
            System.out.println("1. Aggiungi Animale (Zookeper)");
            System.out.println("2. Cura Animale (Veterinario)");
            System.out.println("3. Visualizza Animali");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            String scelta = input.nextLine();

            switch (scelta) {
                case "1":
                    keeper.lavora(zoo, input);
                    break;
                case "2":
                    vet.lavora(zoo, input);
                    break;
                case "3":
                    zoo.stampaTutti();
                    break;
                case "4":
                    attivo = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        input.close();
        System.out.println("Programma terminato.");
    }
}
