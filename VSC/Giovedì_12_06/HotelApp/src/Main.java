import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("\n== Menu ==");
            System.out.println("1. Inserisci nuovo ospite");
            System.out.println("2. Effettua prenotazione");
            System.out.println("3. Visualizza prenotazioni");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine(); // pulizia buffer

            switch (scelta) {
                case 1 -> {
                    System.out.print("Nome ospite: ");
                    String nome = input.nextLine();
                    PrenotazioneManager.inserisciOspite(nome);
                }
                case 2 -> {
                    System.out.print("ID ospite: ");
                    int idOspite = input.nextInt();
                    System.out.print("ID camera: ");
                    int idCamera = input.nextInt();
                    PrenotazioneManager.effettuaPrenotazione(idOspite, idCamera);
                }
                case 3 -> PrenotazioneManager.visualizzaPrenotazioni();
                case 4 -> continua = false;
                default -> System.out.println("Scelta non valida.");
            }
        }

        input.close();
        System.out.println("Uscita dal programma.");
    }
}
