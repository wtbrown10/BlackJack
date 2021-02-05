package com.will;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    Deck deck = new Deck();
    Random rand = new Random();
    ArrayList<String> freshDeck;
    Player player1 = new Player(Player.getName(), Player.getTokens());


//
//    public String dealCards() {
//        freshDeck = deck.shuffleCards();
//
//
//        return freshDeck.get(0);
//    }
}
