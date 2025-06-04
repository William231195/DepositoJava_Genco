package Private;
import java.util.ArrayList;
import java.util.Scanner;

public class ClasseStudenti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Professore professore1 = new Professore("Michele", "Rossi", "Matematica");
        Professore professore2 = new Professore("Savino", "Verdi", "Informatica");

        Studente studente1 = new Studente("Anna", "Bianchi", 8, professore1);
        Studente studente2 = new Studente("Luigi", "Neri", 9, professore2);
        Studente studente3 = new Studente("Marco", "Rossi", 7, professore1);

        ArrayList<Studente> lista = new ArrayList<>();
        lista.add(studente1);
        lista.add(studente2);
        lista.add(studente3);

        System.out.println("Lista Studenti:");
        for (Studente s : lista) {
            System.out.println(s);
        }
        System.out.println("Totale studenti: " + lista.size());

        System.out.print("Cerca studente per nome: ");
        String nome = input.nextLine();
        boolean trovato = false;

        for (Studente s : lista) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Trovato: " + s);
                trovato = true;
            }
        }

        if (!trovato) {
            System.out.println("Studente non trovato.");
        }

        input.close();
    }
}

class Studente {
    private String nome;
    private String cognome;
    private int voto;
    private int id;
    private static int prossimoId = 1;
    private Professore professore;

    public Studente(String nome,String cognome, int voto, Professore prof) {
        this.nome = nome;
        this.cognome = cognome;
        setVoto(voto);
        this.professore = prof;
        this.id = prossimoId++;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    public int getVoto() {
        return voto;
    }

    public int getId() {
        return id;
    }

    public Professore getProfessore() {
        return professore;
    }

    public void setVoto(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;
        } else {
            System.out.println("Errore: il voto deve essere tra 0 e 10.");
        }
    }

    public String toString() {
        return ", ID " + id + ", Nome " + nome + ", Cognome" + cognome + ", Voto " + voto + ", Professore " + professore;
    }
}

class Professore {
    private String nome;
    private String cognome;
    private String materia;

    public Professore(String nome, String cognome, String materia) {
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMateria() {
        return materia;
    }

    public String toString() {
        return nome + " (" + materia + ")";
    }
}
