package com.quizapp.project.controller;

import com.quizapp.project.dto.JwtResponse;
import com.quizapp.project.dto.LoginRequest;
import com.quizapp.project.model.User;
import com.quizapp.project.security.CustomUserDetails;
import com.quizapp.project.security.JwtUtil;
import com.quizapp.project.services.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserController(UserService service, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try {
            user.setRole(com.quizapp.project.model.Role.USER);
            User created = service.register(user);
            return ResponseEntity.ok(created);
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            User user = userDetails.getUser();
            String jwt = jwtUtil.generateToken(userDetails, user.getRole().name());

            return ResponseEntity.ok(new JwtResponse(jwt, user.getUsername(), user.getRole(), user.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
