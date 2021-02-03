package com.will;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    public Card cards = new Card();
    private List<String> deck;

    Random rand = new Random();
//    final String SUITS[] = {"Hearts", "Diamonds", "Spades", "Clubs"};
//    final String CARDNUMBERS[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    Deck() {
        deck = new ArrayList<String>();
        for (int i = 0; i < cards.SUITS.length; i++) {
            for (int j = 0; j < cards.CARDNUMBERS.length; j++) {
                deck.add(cards.CARDNUMBERS[j] + " of " + cards.SUITS[i]);
//                System.out.println(deck);
            }
        }

    }

    public ArrayList<String> getDeck(){
        for (String cards: deck) {
//            System.out.println((ArrayList<String>) deck);
        }
        return (ArrayList<String>) deck;
    }



    public List<String> shuffleDeck() {
        Collections.shuffle(deck);
        return deck;
    }
}

