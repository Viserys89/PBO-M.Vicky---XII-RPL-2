import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/javadbpajimmy";
    private static final String username = "root";
    private static final String password = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM examplejavadb");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                System.out.println("ID: " + id + ", Name: " + nama + ", Email: " + email + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
