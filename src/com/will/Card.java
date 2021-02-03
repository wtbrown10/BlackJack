package com.will;

import java.util.ArrayList;
import java.util.Random;

public class Card {
    public String SUITS[];
    public String CARDNUMBERS[];
    public ArrayList<String> cardValue = new ArrayList<>();
    Random rand = new Random();


    public Card() {
       SUITS = new String[]{"Hearts", "Diamonds", "Spades", "Clubs"};
       CARDNUMBERS = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    }

    public ArrayList<String> getCardValue() {
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < CARDNUMBERS.length; j++) {
                cardValue.add(CARDNUMBERS[j] + " of " + SUITS[i]);
            }
        }
        return cardValue;
    }

}
