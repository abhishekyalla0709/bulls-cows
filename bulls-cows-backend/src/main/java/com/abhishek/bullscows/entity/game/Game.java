package com.abhishek.bullscows.entity.game;

import com.abhishek.bullscows.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String secretNumber;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    private int attempts;

    private LocalDateTime createdAt;

    private LocalDateTime finishedAt;
}
