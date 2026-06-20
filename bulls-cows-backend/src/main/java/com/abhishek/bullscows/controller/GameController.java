package com.abhishek.bullscows.controller;

import com.abhishek.bullscows.dto.GameStartRequest;
import com.abhishek.bullscows.dto.GameStartResponse;
import com.abhishek.bullscows.service.GameService.GameStartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameStartService gameStartService;

    public GameController(GameStartService gameStartService){
        this.gameStartService = gameStartService;
    }

    @PostMapping("/start")
    public ResponseEntity<GameStartResponse> start(@Valid @RequestBody GameStartRequest request){
        GameStartResponse response = gameStartService.startGame(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
