package com.project.forum.service;

import com.project.forum.db.dao.CommentDao;

public class CommentService {
    private CommentDao commentDao;

    private CommentService() {
        commentDao = new CommentDao();
    }

    public int getCountCommentsByPostId(Integer postId) {
        return commentDao.getCountCommentsById(postId);
    }
}
