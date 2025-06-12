import java.sql.*;

public class PrenotazioneManager {

    public static void inserisciOspite(String nome) {
        String sql = "INSERT INTO utenti(nome) VALUES(?)";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
            System.out.println("Ospite inserito.");
        } catch (SQLException e) {
            System.out.println("Errore inserimento ospite: " + e.getMessage());
        }
    }

    public static void effettuaPrenotazione(int idOspite, int idCamera) {
        String sql = "INSERT INTO prenotazioni(id_ospite, id_camera) VALUES(?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idOspite);
            pstmt.setInt(2, idCamera);
            pstmt.executeUpdate();
            System.out.println("Prenotazione effettuata.");
        } catch (SQLException e) {
            System.out.println("Errore prenotazione: " + e.getMessage());
        }
    }

    public static void visualizzaPrenotazioni() {
        String sql = "SELECT p.id, u.nome AS ospite, c.nome AS camera "
                   + "FROM prenotazioni p "
                   + "JOIN utenti u ON p.id_ospite = u.id "
                   + "JOIN camere c ON p.id_camera = c.id";
        try (Connection conn = Database.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Prenotazione #" + rs.getInt("id") +
                                   " - Ospite: " + rs.getString("ospite") +
                                   " - Camera: " + rs.getString("camera"));
            }
        } catch (SQLException e) {
            System.out.println("Errore visualizzazione: " + e.getMessage());
        }
    }
}
