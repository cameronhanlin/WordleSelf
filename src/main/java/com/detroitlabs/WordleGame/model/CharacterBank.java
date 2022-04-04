package com.detroitlabs.WordleGame.model;

public class CharacterBank {//two strings


    String character;
    String color;

    public CharacterBank(String character) {
        this.character = character;
        color = "#FFFFFF";
    }

    public CharacterBank(String character, String color){
        this.character = character;
        this.color = color;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
