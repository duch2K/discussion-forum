package com.project.forum.db.dao;

import com.project.forum.db.DBConnection;
import com.project.forum.bean.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDao {
    private DBConnection dbConnection;
    private String tableName;

    public PostDao() {
        this.dbConnection = new DBConnection("jdbc:mysql://localhost:3306/javaee_lab7?serverTimezone=UTC", "root", "nur26erb");
        this.tableName = "post";
    }

    private Post getPostObject(Integer id, Integer userId, String title, String text, Integer countLike, Date day) {
        Post post = new Post();
        post.setId(id);
        post.setUserId(userId);
        post.setTitle(title);
        post.setText(text);
        post.setCountLike(countLike);
        post.setDay(day);
        return post;
    }

    public Post getPostById(Integer postId) {
        dbConnection.openConnect();
        Post post = null;
        ResultSet resultSet = dbConnection.getData("SELECT * FROM " + tableName + " WHERE id = " + postId);

        try {
            resultSet.next();
            Integer id = resultSet.getInt("id");
            Integer userId = resultSet.getInt("user_id");
            String title = resultSet.getString("title");
            String text = resultSet.getString("text");
            Integer countLike = resultSet.getInt("likes");
            Date day = resultSet.getDate("date");

            post = getPostObject(id, userId, title, text, countLike, day);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("GET Post by ID error!");
        }

        return post;
    }

    public List<Post> getAllPost() {
        dbConnection.openConnect();
        List<Post> posts = new ArrayList<>();
        ResultSet resultSet = dbConnection.getData("SELECT * FROM " + tableName);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer userId = resultSet.getInt("user_id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("text");
                Integer countLike = resultSet.getInt("likes");
                Date day = resultSet.getDate("date");

                posts.add(getPostObject(id, userId, title, text, countLike, day));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("GET ALL Post error!");
        }

        return posts;
    }
}
