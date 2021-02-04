package com.will;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hand {
    private List<String> hand;
    Deck deck = new Deck();
    public List<String> placeHolder;
    Scanner scanner = new Scanner(System.in);


    public Hand() {
        hand = new ArrayList<>();
        placeHolder = new ArrayList<String>();

    }

    public List<String> drawCard() {
        for (int count = 0; count < 1; count++) {
            hand.add(deck.remove(0));
            System.out.println(hand + " hand value: " + calculateHand());
            if (calculateHand() > 21) {
                System.out.println("You Bust Game Over!");
                endGame();
            } else if (calculateHand() == 21 && hand.size() == 2) {
                System.out.println("BlackJack You Win!!");
                endGame();
            } else if (calculateHand() == 21) {
                System.out.println("21 You Win!!");
                endGame();
            }
        }
        placeHolder.clear();
        return hand;
    }

    public void initialDraw() {
        deck.shuffleDeck();
        drawCard();
        drawCard();
        hitOrStand();

    }

    public int calculateHand() {
        int add = 0;
        for (int count = 0; count < getFirstIndex().size(); count++) {
            if ("2".equals(getFirstIndex().get(count))) {
                add += 2;
            } else if ("3".equals(getFirstIndex().get(count))) {
                add += 3;
            } else if ("4".equals(getFirstIndex().get(count))) {
                add += 4;
            } else if ("5".equals(getFirstIndex().get(count))) {
                add += 5;
            } else if ("6".equals(getFirstIndex().get(count))) {
                add += 6;
            } else if ("7".equals(getFirstIndex().get(count))) {
                add += 7;
            } else if ("8".equals(getFirstIndex().get(count))) {
                add += 8;
            } else if ("9".equals(getFirstIndex().get(count))) {
                add += 9;
            } else if ("10".equals(getFirstIndex().get(count)) || "J".equals(getFirstIndex().get(count)) || "Q".equals(getFirstIndex().get(count)) || "K".equals(getFirstIndex().get(count))) {
                add += 10;
            } else if ("A".equals(getFirstIndex().get(count))) {
                add += 11;
            }
            placeHolder.clear();
        }
        return add;
    }

    public List<String> showHand() {
        return hand;
    }

    public List<String> getFirstIndex() {
        for (int count = 0; count < hand.size(); count++) {
            placeHolder.add(hand.get(count).substring(0, 2).trim());
        }
        return placeHolder;
    }

    public void stand() {
        System.out.println("Dealer will play now");
        endGame();
    }

    public void hit() {
        drawCard();
    }

    public void hitOrStand() {
        String value;

        while (true) {

            System.out.print("would you like to (HIT) or (STAND)? ");
            value = scanner.nextLine();
            if (value.toLowerCase().trim().equals("hit")) {
                hit();
                hitOrStand();
                break;
            } else if (value.toLowerCase().trim().equals("stand")) {
                stand();
                break;
            } else {
                System.out.println("Type hit if you would like another card or stand if you wish to end turn!");
            }
        }
    }

    public void endGame() {
        playAgain();
    }

    public void playAgain() {
        String value;
        System.out.println("would you like to play again (YES) or (NO)? ");
        value = scanner.nextLine();
        if (value.trim().equals("yes")) {
            hand.clear();
            deck = new Deck();
            System.out.println(deck);
            initialDraw();
        } else if (value.trim().equals("no")) {
            System.out.println("goodbye!");
        }
        return;
    }
}


