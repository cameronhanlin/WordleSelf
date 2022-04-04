package com.detroitlabs.WordleGame.service;

import com.detroitlabs.WordleGame.model.WordBank;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WordGeneratorService {
    public String[] getWord() {
        RestTemplate restTemplate = new RestTemplate();
        //Todo: complete api request
//        WordBank[] randomWord = restTemplate.getForObject("http://random-word-api.herokuapp.com/word?number=1&swear=0",
//                WordBank[].class);
//        return randomWord[0];
                return restTemplate.getForObject(
                "http://random-word-api.herokuapp.com/word?number=1&swear=1", String[].class);
    }
}


