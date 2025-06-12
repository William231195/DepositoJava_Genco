import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String USER = "hr";
    private static final String PASSWORD = "hr";

    public static Connection connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Oracle non trovato: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Errore di connessione Oracle: " + e.getMessage());
            return null;
        }
    }
}
