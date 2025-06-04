package Private;

import java.util.Scanner;

public class Persona {
    // Campi privati
    private String nome;
    private int eta;

    // Costruttore
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    // Metodo privato
    private boolean verificaMaggiorenne() {
        return eta >= 18;
    }

    // Metodo pubblico
    public void stampaStatus() {
        if (verificaMaggiorenne()) {
            System.out.println(nome + " è maggiorenne.");
        } else {
            System.out.println(nome + " non è maggiorenne.");
        }
    }

    // Metodo main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il nome: ");
        String nome = input.nextLine();

        System.out.print("Inserisci l'età: ");
        int eta = input.nextInt();

        Persona p = new Persona(nome, eta);

        p.stampaStatus();

        // Prova modifica età
        p.setEta(25);
        System.out.println("Età aggiornata: " + p.getEta());
        p.stampaStatus();

        input.close();
    }
}
