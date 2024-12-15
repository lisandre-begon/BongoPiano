import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static String URL = "jdbc:mysql://mysql-242c1f32-bongo-piano.e.aivencloud.com:25683/bongo_piano"; // URL de la base
    static String USER = "avnadmin"; // Utilisateur MySQL
    static String PASSWORD = "AVNS_NnTlZWyNeJEU49HwIAs"; // Mot de passe MySQL

    // Méthode pour obtenir la connexion à la base de données
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
