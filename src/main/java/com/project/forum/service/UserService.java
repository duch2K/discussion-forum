package com.project.forum.service;

import com.project.forum.db.dao.UserDao;
import com.project.forum.bean.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
