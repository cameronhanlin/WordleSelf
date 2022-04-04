package com.detroitlabs.WordleGame.controller;

import com.detroitlabs.WordleGame.data.LetterRepository;
import com.detroitlabs.WordleGame.model.WordBank;
import com.detroitlabs.WordleGame.service.WordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.Locale;

@Controller
public class WordController {
    private boolean secondGuessMade = false;

    @Autowired
    LetterRepository letterRepository;


    @RequestMapping("/")
    public String displayHome(ModelMap modelMap) {
        letterRepository.clearAll();
        modelMap.put("CharBank", letterRepository.getCharacterBanks());
        modelMap.put("wordLength", letterRepository.getCharacterBanks().size());
        return "home";
    }

    @RequestMapping("/page2")
    public String displayPage2(@RequestParam String keyword, ModelMap modelMap) {
        if(keyword.equals("Solve Puzzle")) {
            keyword=letterRepository.showAnswer();
        }
        keyword = keyword.toLowerCase();
        modelMap.put("wordLength", letterRepository.getCharacterBanks().size());
        if (keyword.length() != letterRepository.getCharacterBanks().size()) {
            if (!secondGuessMade) {
                return "errorMismatch";
            } else {
                return "errorMismatchPage2";
            }
        }
        secondGuessMade = true;
        letterRepository.recordGuess(keyword);
        LetterRepository.guessCount++; //LOOK AT OUR PUBLIC STATIC NUMBER!!!

        //TODO build in model map for hint here
        String hint = letterRepository.getAHint();
        int place = Integer.parseInt(hint.substring(1))+1;
        hint = hint.substring(0,1);
        if(hint.equals(" ")){
            modelMap.put("wholeHint", "You've already solved the puzzle, why do you need a hint?");
        } else {
            modelMap.put("wholeHint", "Letter number "+place+" is a '"+hint+"'");
        }

        modelMap.put("guessCount", LetterRepository.guessCount);
        modelMap.put("userGuess", keyword);
        modelMap.put("CharBank", letterRepository.getCharacterBanks());
        modelMap.put("PriorGuesses", letterRepository.getPriorGuesses());
        modelMap.put("winCheck", letterRepository.winCheck(keyword));
        modelMap.put("showAnswer", letterRepository.showAnswer());
        return "page2";
    }

    @RequestMapping("/errorMismatch")
    public String displayError() {
        return "errorMismatch";
    }

    @RequestMapping("errorMismatchPage2")
    public String displayErrorAfterSecondGuess(ModelMap modelMap) {
        modelMap.put("wordLength", letterRepository.getCharacterBanks().size());
        return "errorMismatchPage2";
    }

    //NEW COMMENT!
}
