package com.project.forum.db.dao;

import com.project.forum.db.DBConnection;
import com.project.forum.bean.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDao {
    private DBConnection dbConnection;
    private String tableName;

    public CommentDao() {
        this.dbConnection = new DBConnection("jdbc:mysql://localhost:3306/javaee_lab7?serverTimezone=UTC", "root", "nur26erb");
        this.tableName = "comment";
    }

    public Comment getCommentObject(Integer id, Integer userId, Integer postId, String text, Integer countLike, Date day) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUserId(userId);
        comment.setPostId(postId);
        comment.setText(text);
        comment.setCountLike(countLike);
        comment.setDay(day);
        return comment;
    }

    public List<Comment> getCommentsByPostID(Integer postId) {
        List<Comment> comments = new ArrayList<>();
        dbConnection.openConnect();
        ResultSet resultSet = dbConnection.getData("SELECT * FROM " + tableName + " WHERE post_id = " + postId);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer userId = resultSet.getInt("user_id");
                Integer postId_ = resultSet.getInt("post_id");
                String text = resultSet.getString("text");
                Integer countLike = resultSet.getInt("likes");
                Date day = resultSet.getDate("date");

                comments.add(getCommentObject(id, userId, postId_, text, countLike, day));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("GET Comments by Post_ID error!");
        }

        return comments;
    }

    public int getCountCommentsById(Integer postId) {
        dbConnection.openConnect();
        int countLikes = 0;
        ResultSet resultSet = dbConnection.getData("SELECT * FROM " + tableName + " WHERE post_id = " + postId);

            try {
                while (resultSet.next()) {
                    countLikes++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("GET COUNT(post_id) error!");
            }

            return countLikes;
    }
}
