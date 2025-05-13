import java.util.Scanner;
public class EsercizioInputDiversiTipi {
    public static void main(String[] args) {
        // Creazione di un oggetto Scanner per leggere l'input da tastiera
        Scanner myObj = new Scanner(System.in);

        // Chiedere all'utente di inserire un numero intero
        System.out.print("Inserisci un numero intero: ");
        int numeroIntero = myObj.nextInt(); // Leggere il numero intero inserito dall'utente

        // Chiedere all'utente di inserire un numero intero
        System.out.print("Inserisci il primo numero Decimale Float: ");
        Float numeroDecimale1 = myObj.nextFloat(); // Leggere il numero decimale Float inserito dall'utente


        // Chiedere all'utente di inserire un numero decimale
        System.out.print("Inserisci il secondo numero decimale Double: ");
        double numeroDecimale2 = myObj.nextDouble(); // Leggere il numero decimale Double inserito dall'utente

        // Chiedere all'utente di inserire una stringa
        System.out.print("Inserisci una stringa: ");
        String stringa = myObj.next(); // Leggere la stringa inserita dall'utente

        // Chiedere all'utente di inserire un booleano
        System.out.print("Inserisci un valore booleano (true/false): ");
        boolean valoreBooleano = myObj.nextBoolean(); // Leggere il valore booleano inserito dall'utente

        // Stampa i valori inseriti dall'utente
        System.out.println("Numero intero: " + numeroIntero);
        System.out.println("Numero decimale Float: " + numeroDecimale1);
        System.out.println("Numero decimale Double: " + numeroDecimale2);
        System.out.println("Stringa: " + stringa);
        System.out.println("Valore booleano: " + valoreBooleano);

    }
    
}
