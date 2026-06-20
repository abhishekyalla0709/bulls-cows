package com.abhishek.bullscows.dto;

import com.abhishek.bullscows.entity.game.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartResponse {
    private Long gameId;
    private GameStatus gameStatus;
    private String message;
}
