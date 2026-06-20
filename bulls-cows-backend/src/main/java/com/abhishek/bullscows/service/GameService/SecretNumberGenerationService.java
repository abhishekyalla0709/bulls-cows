package com.abhishek.bullscows.service.GameService;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SecretNumberGenerationService {

    public String generateRandomNumber(){
        Random random = new Random();
        int digit_1 = random.nextInt(9) + 1;
        int digit_2 = random.nextInt(10);
        while(digit_2==digit_1){
            digit_2= random.nextInt(10);
        }
        int digit_3 = random.nextInt(10);
        while(digit_3==digit_1 || digit_3==digit_2){
            digit_3= random.nextInt(10);
        }
        int digit_4 = random.nextInt(10);
        while(digit_4 ==digit_1 || digit_4 ==digit_2 || digit_4==digit_3){
            digit_4 = random.nextInt(10);
        }
        String number = ""+digit_1+digit_2+digit_3+digit_4;
        return number;
    }

}
