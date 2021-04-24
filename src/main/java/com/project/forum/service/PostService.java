package com.project.forum.service;

import com.project.forum.db.dao.PostDao;
import com.project.forum.bean.Post;

import java.util.List;

public class PostService {
    private PostDao postDao;

    public PostService() {
        this.postDao = new PostDao();
    }

    public List<Post> getAllPost() {
        return postDao.getAllPost();
    }
}
