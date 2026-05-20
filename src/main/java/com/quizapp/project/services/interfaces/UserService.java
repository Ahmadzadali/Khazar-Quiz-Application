package com.quizapp.project.services.interfaces;

import com.quizapp.project.model.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    List<User> getAll();

    void delete(Long id);
}
