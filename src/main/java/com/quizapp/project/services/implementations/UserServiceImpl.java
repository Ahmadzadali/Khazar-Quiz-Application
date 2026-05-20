package com.quizapp.project.services.implementations;

import com.quizapp.project.model.User;
import com.quizapp.project.model.Role;
import com.quizapp.project.repository.UserRepository;
import com.quizapp.project.services.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        if(repo.findByUsername(user.getUsername()) != null){
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(Role.USER); // Default role
        }
        return repo.save(user);
    }

    @Override
    public User login(String username, String password) {
        // Since we use AuthManager, this method is no longer strictly used for auth
        // but we'll leave it or modify it just to fetch the user.
        return repo.findByUsername(username); 
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
