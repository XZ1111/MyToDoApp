package com.luckydraw.todoapp.service;

import com.luckydraw.todoapp.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
