import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnessione {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        String user = "hr";
        String password = "hr";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connessione riuscita al database Oracle!");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Connessione fallita: " + e.getMessage());
        }
    }
}
