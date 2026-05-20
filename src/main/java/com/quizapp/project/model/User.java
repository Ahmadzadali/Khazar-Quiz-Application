package com.quizapp.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    
    private String firstName;
    private String lastName;
    private Integer age;

    @Column(columnDefinition = "TEXT")
    private String photoBase64;

    @Enumerated(EnumType.STRING)
    private Role role;

    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Result> results;
}



