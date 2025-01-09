import java.sql.*;

public class MyDB {
    public static void main(String[] args) {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login_schema", "root", "2242");

            // Create a statement to execute SQL queries
            Statement statement = connection.createStatement();

            // Execute the query and get the results
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Iterate through the result set and print each row
            while (resultSet.next()) {
                // Replace 'column_name1' and 'column_name2' with actual column names from your 'users' table
                int id = resultSet.getInt("idusers"); // Example column
                String username = resultSet.getString("username"); // Example column
                String password = resultSet.getString("password"); // Example column

                System.out.println("ID: " + id + ", Username: " + username + ", password: " + password);
            }

            // Close the connection
            connection.close();

        } catch (SQLException e) {
            // Print detailed error information
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
