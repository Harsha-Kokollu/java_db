package org.studyeasy.services;

import org.studyeasy.config.DBConnection;
import org.studyeasy.models.User;
import org.studyeasy.models.User;
import org.studyeasy.config.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = null;

        try {
            connection = org.studyeasy.config.DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return users;
    }
}
