package com.will;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    public Card cards = new Card();
    private List<String> deck;
//    public List<String> hand;


    Random rand = new Random();

    public Deck() {
        deck = new ArrayList<String>();
        for (int i = 0; i < cards.SUITS.length; i++) {
            for (int j = 0; j < cards.CARDNUMBERS.length; j++) {
                deck.add(cards.CARDNUMBERS[j] + " of " + cards.SUITS[i]);
            }
        }
    }

    public ArrayList<String> getDeck(){
        for (String cards: deck) {
//            System.out.println((ArrayList<String>) deck);
        }
        return (ArrayList<String>) deck;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
        Collections.shuffle(deck);
    }

    public int numberOfCardsLeft() {
        return deck.size();
    }


    public String remove(int i) {
       return deck.remove(i);
    }

}



