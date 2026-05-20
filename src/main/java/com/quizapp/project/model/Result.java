package com.quizapp.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Result{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    private LocalDateTime completedAt;

    @PrePersist
    protected void onCreate() {
        if (completedAt == null) completedAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quizId")
    private Quiz quiz;
}
