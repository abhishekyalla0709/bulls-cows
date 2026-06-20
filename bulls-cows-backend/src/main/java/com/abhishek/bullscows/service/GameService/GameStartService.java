package com.abhishek.bullscows.service.GameService;

import com.abhishek.bullscows.dto.GameStartRequest;
import com.abhishek.bullscows.dto.GameStartResponse;
import com.abhishek.bullscows.entity.User;
import com.abhishek.bullscows.entity.game.Game;
import com.abhishek.bullscows.entity.game.GameStatus;
import com.abhishek.bullscows.exception.InValidCredentialsException;
import com.abhishek.bullscows.repository.GameRepository;
import com.abhishek.bullscows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GameStartService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final SecretNumberGenerationService secretNumberGenerationService;

    public GameStartService(UserRepository userRepository,
                            GameRepository gameRepository,
                            SecretNumberGenerationService secretNumberGenerationService){
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.secretNumberGenerationService = secretNumberGenerationService;
    }

    public GameStartResponse startGame(GameStartRequest request){
        String email = request.getEmail();
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            throw new InValidCredentialsException("User with email " + request.getEmail() + " not exist");
        }

        String secretNumber = secretNumberGenerationService.generateRandomNumber();
        Game game = new Game();
        game.setUser(user.get());
        game.setAttempts(0);
        game.setCreatedAt(LocalDateTime.now());
        game.setStatus(GameStatus.ACTIVE);
        game.setSecretNumber(secretNumber);

        Game savedGame = gameRepository.save(game);

        GameStartResponse response = new GameStartResponse();
        response.setGameId(savedGame.getId());
        response.setGameStatus(savedGame.getStatus());
        response.setMessage("new game started");
        return response;
    }

}
