import java.util.Scanner;

   // Esempio di utilizzo della classe Scanner per leggere input da tastiera.



public class ScannerEsempio {
    public static void main(String[] args) {
        Scanner myObj  = new Scanner(System.in);  // Creazione di un oggetto Scanner per leggere l'input da tastiera

        System.out.print("Enter Username: ");   // Chiedere all'utente di inserire un numero

        String userName = myObj.nextLine();  // Leggere la stringa inserita dall'utente

        System.out.println("Username is: " + userName);  // Stampa il nome utente inserito
        
    }
}       //Outpput user input

