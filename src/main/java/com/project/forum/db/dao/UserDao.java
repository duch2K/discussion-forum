package com.project.forum.db.dao;

import com.project.forum.db.DBConnection;
import com.project.forum.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private DBConnection dbConnection;
    private String tableName;

    // constructors
    public UserDao() {
        this.dbConnection = new DBConnection("jdbc:mysql://localhost:3306/javaee_lab7?serverTimezone=UTC", "root", "nur26erb");
        this.tableName = "user";
    }

    private User getUserObject(Integer id, String username, String password, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        return user;
    }

    public User getUserById(Integer id) {
        dbConnection.openConnect();
        User user = null;
        ResultSet resultSet = dbConnection.getData("SELECT * FROM " + tableName + " WHERE id = " + id);
        try {
            resultSet.next();

            Integer userId = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");

            user = getUserObject(userId, username, password, name);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("GET USER By ID error!");
        }

        return user;
    }
}
