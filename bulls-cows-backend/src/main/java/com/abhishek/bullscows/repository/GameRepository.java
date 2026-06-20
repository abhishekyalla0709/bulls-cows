package com.abhishek.bullscows.repository;

import com.abhishek.bullscows.entity.game.Game;
import com.abhishek.bullscows.entity.game.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByUserEmailAndStatus(String email, GameStatus status);
}
