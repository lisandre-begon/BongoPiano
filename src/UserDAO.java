import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Créer la table User
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "userId VARCHAR(255) PRIMARY KEY, "
                + "username VARCHAR(255) NOT NULL, "
                + "password VARCHAR(255) NOT NULL, "
                + "balance FLOAT, "
                + "isOnline BOOLEAN"
                + ");";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'User' créée avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de la table : " + e.getMessage());
        }
    }

    // Ajouter un utilisateur à la table User
    public static void addUser(User user) {
        String insertSQL = "INSERT INTO User (userId, username, password, balance, isOnline) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setFloat(4, user.getBalance());
            preparedStatement.setBoolean(5, user.isOnline());

            preparedStatement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    // Récupérer un utilisateur par son username
    public static User getUserByUsername(String username) {
        String query = "SELECT * FROM User WHERE username = ?";
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getString("userId"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getFloat("balance"),
                            resultSet.getBoolean("isOnline")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
        }

        return user;
    }

    // Mettre à jour les informations d'un utilisateur
    public static void updateUser(User user) {
        String updateSQL = "UPDATE User SET username = ?, password = ?, balance = ?, isOnline = ? WHERE userId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setFloat(3, user.getBalance());
            preparedStatement.setBoolean(4, user.isOnline());
            preparedStatement.setString(5, user.getUserId());

            preparedStatement.executeUpdate();
            System.out.println("Utilisateur mis à jour avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        }
    }

    // Supprimer un utilisateur
    public static void deleteUser(String userId) {
        String deleteSQL = "DELETE FROM User WHERE userId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }

    // Vérifier si un utilisateur existe avec un certain username et mot de passe
    public static boolean verifyUserCredentials(String username, String password) {
        String query = "SELECT * FROM User WHERE username = ? AND password = ?";
        boolean valid = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                valid = resultSet.next(); // Si un utilisateur est trouvé, les identifiants sont valides
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification des identifiants : " + e.getMessage());
        }

        return valid;
    }

    // Méthode pour récupérer tous les utilisateurs
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getFloat("balance"),
                        rs.getBoolean("isOnline")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }

        return users;
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        // Créer la table si nécessaire
        createTable();

        // Ajouter un utilisateur
        User user = new User("user123", "JohnDoe", "password123", 100.50f, true);
        addUser(user);

        // Vérifier un utilisateur
        boolean isValid = verifyUserCredentials("JohnDoe", "password123");
        System.out.println("Identifiants valides : " + isValid);
    }
}
