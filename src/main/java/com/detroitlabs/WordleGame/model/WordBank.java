package com.detroitlabs.WordleGame.model;

import com.detroitlabs.WordleGame.service.WordGeneratorService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WordBank {//not needed because the JSON format does not have a ({) and therefore, no object
    String randomWord;
//    List<String> randomWords;

    public String getRandomWord() {
        WordGeneratorService wordGeneratorService = new WordGeneratorService();
        return wordGeneratorService.getWord()[0];
    }
}




