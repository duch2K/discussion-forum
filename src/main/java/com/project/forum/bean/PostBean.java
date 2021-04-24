package com.project.forum.bean;

import java.io.Serializable;
import java.util.List;

public class PostBean implements Serializable {
    private Post post = null;
    private List<Comment> comment = null;

    // empty constructor
    public PostBean() {}

    // getter and setters
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
