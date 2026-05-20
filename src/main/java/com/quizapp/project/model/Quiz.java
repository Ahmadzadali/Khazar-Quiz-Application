package com.quizapp.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Quiz{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private int timeLimitInSeconds = 300; // default 5 minutes

    @OneToMany(mappedBy = "quiz")
    @JsonManagedReference
    private List<Question> questions;
}


