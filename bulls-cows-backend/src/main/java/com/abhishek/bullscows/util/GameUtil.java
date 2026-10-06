package com.abhishek.bullscows.util;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GameUtil {
    private static final int SECRET_NUMBER_LENGTH = 4;
    private static final int DIGIT_RANGE = 10;

    /**
     * Generates a 4 digit random number where 0 is not the 1st digit
     *
     * @return Secret number as a string
     */
    public static String generateSecretNumber(){
        Set<Integer> digits = new LinkedHashSet<>();
        Random random = new Random();

        int firstDigit = random.nextInt(9) + 1;
        digits.add(firstDigit);
        while (digits.size()<SECRET_NUMBER_LENGTH){
            int randomDigit = random.nextInt(DIGIT_RANGE);
            digits.add(randomDigit);
        }
        StringBuilder sb = new StringBuilder();
        for(Integer digit : digits){
            sb.append(digit);
        }
        return sb.toString();
    }
}
