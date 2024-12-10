import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://mysql-242c1f32-bongo-piano.e.aivencloud.com:25683/bongo_piano"; // URL de la base
        String user = "avnadmin"; // Utilisateur MySQL
        String password = "AVNS_NnTlZWyNeJEU49HwIAs"; // Mot de passe MySQL

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
