package com.quizapp.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.quizapp.project.model.Role;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private Role role;
    private Long id;
}
