package com.will;

import java.util.ArrayList;

public class Player {
    private static String name;
    private static int tokens;
    private ArrayList<String> cards;
    Console console = new Console();

    public Player(String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
        this.cards = cards;
    }


    public static String getName() {
        return name;
    }

    public static int getTokens() {
        return tokens;
    }

    public void addPlayers() {
        console.getString("whats your name? ");
        System.out.println();
    }
}
