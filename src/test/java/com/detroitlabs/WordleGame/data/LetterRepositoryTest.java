package com.detroitlabs.WordleGame.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterRepositoryTest {

    @Test
    void countOfCharShouldBe2() {
        LetterRepository testLetterRepository = new LetterRepository();
        int result = testLetterRepository.countOfChar("Collin", "l");
        System.out.println("Count of letter " + result);

        assertEquals(result, 2);
    }

    @Test
    void countOfCharShouldBe1() {
        LetterRepository testLetterRepository = new LetterRepository();
        int result = testLetterRepository.countOfChar("Cameron", "m");
        System.out.println("Count of letter " + result);

        assertEquals(result, 1);
    }
}