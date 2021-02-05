package com.will;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hand {
    private List<String> hand;
    private List<String> dealerHand;
    Deck deck = new Deck();
    public List<String> placeHolder;
    private String dealerFirstCard;
    Scanner scanner = new Scanner(System.in);


    public Hand() {
        hand = new ArrayList<>();
        placeHolder = new ArrayList<String>();
        dealerHand = new ArrayList<>();
        this.dealerFirstCard = dealerFirstCard;
    }

    public List<String> drawCard() {
        for (int count = 0; count < 1; count++) {
            hand.add(deck.remove(0));
            System.out.println(hand + " Player hand value: " + calculateHand());
            if (calculateHand() > 21) {
                System.out.println("You Bust Game Over!");
                endGame();
            } else if (calculateHand() == 21 && hand.size() == 2) {
                System.out.println("BlackJack You Win!!");
                endGame();
            } else if (calculateHand() == 21) {
                System.out.println("21!");
            }
        }
        placeHolder.clear();
        return hand;
    }

    public void dealerDrawCard() {
        for (int count = 0; count < 1; count++) {
            dealerHand.add(deck.remove(0));
            System.out.println(dealerHand + " Dealer Hand value: " + calculateDealerHand());
        }
    }

    public void dealerDrawHidden() {
        for (int count = 0; count < 1; count++) {
            dealerHand.add(deck.remove(0));
            System.out.println(dealerHand.get(0) + ", [card face down]");
        }
    }

    public int checkDealerBlackJack() {
        if(calculateDealerHand() == 21) {
            System.out.println("Dealer Has BlackJack!");
        }
        return calculateDealerHand();
    }

    public void initialDraw() {
        deck.shuffleDeck();
        drawCard();
        next();
        dealerDrawCard();
        next();
        drawCard();
        next();
        dealerDrawHidden();
        System.out.println(".....Checking to see if dealer has blackjack");
        next();

        while(true) {
            if(checkDealerBlackJack() == 21 && calculateHand() == 21) {
                System.out.println("Push!! Draw!!");
            } else if(checkDealerBlackJack() == 21) {
                System.out.println(getDealerHand());
                System.out.println(calculateDealerHand());
                System.out.println("Dealer Has BlackJack!! Sorry You Lose!!");
                next();
                endGame();
                break;
            }
            System.out.println("Dealer does not have blackJack");
            hitOrStand();
        }

    }

    public int calculateHand() {
        int add = 0;
        placeHolder.clear();
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

    public int calculateDealerHand() {
        int add = 0;
        placeHolder.clear();
        for (int count = 0; count < getFirstIndexDealer().size(); count++) {
            if ("2".equals(getFirstIndexDealer().get(count))) {
                add += 2;
            } else if ("3".equals(getFirstIndexDealer().get(count))) {
                add += 3;
            } else if ("4".equals(getFirstIndexDealer().get(count))) {
                add += 4;
            } else if ("5".equals(getFirstIndexDealer().get(count))) {
                add += 5;
            } else if ("6".equals(getFirstIndexDealer().get(count))) {
                add += 6;
            } else if ("7".equals(getFirstIndexDealer().get(count))) {
                add += 7;
            } else if ("8".equals(getFirstIndexDealer().get(count))) {
                add += 8;
            } else if ("9".equals(getFirstIndexDealer().get(count))) {
                add += 9;
            } else if ("10".equals(getFirstIndexDealer().get(count)) || "J".equals(getFirstIndexDealer().get(count)) || "Q".equals(getFirstIndexDealer().get(count)) || "K".equals(getFirstIndexDealer().get(count))) {
                add += 10;
            } else if ("A".equals(getFirstIndexDealer().get(count))) {
                add += 11;
            }
            placeHolder.clear();
        }
        return add;
    }

    public List<String> getHand() {
        return hand;
    }
    public List<String> getDealerHand() {
        return dealerHand;
    }

    public List<String> getFirstIndex() {
        for (int count = 0; count < hand.size(); count++) {
            placeHolder.add(hand.get(count).substring(0, 2).trim());
        }
        return placeHolder;
    }
    public List<String> getFirstIndexDealer() {
        for (int count = 0; count < dealerHand.size(); count++) {
            placeHolder.add(dealerHand.get(count).substring(0, 2).trim());
        }
        return placeHolder;
    }

    public void stand() {
        System.out.println("Dealer will play now");
        next();
        dealersTurn();
    }

    public void dealerStand() {
        System.out.println("Dealer stands");
    }



    public void dealersTurn() {
        System.out.println(getDealerHand());
        System.out.println(calculateDealerHand());
        next();
        dealerHitOrStay();
    }

    public void dealerHitOrStay() {
        if (calculateDealerHand() > 21) {
            System.out.println("Dealer Bust!! You Win!!");
            next();
            endGame();
        } else if (calculateDealerHand() <= 15) {
            dealerDrawCard();
            next();
            dealerHitOrStay();
        } else {
            dealerStand();
            next();
            checkWinner();
        }
    }

    public void checkWinner() {
        if(calculateHand() == calculateDealerHand()){
            System.out.println("You Push!! Draw!!");
            next();
            endGame();
        }else if(calculateHand() > calculateDealerHand()) {
            System.out.println("You Win " + calculateHand() + " Beats " + calculateDealerHand());
            next();
            endGame();
        }
        System.out.println("Dealer Wins " + calculateDealerHand() + " Beats " + calculateHand());
        next();
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
            dealerHand.clear();
            deck = new Deck();
            initialDraw();
        } else if (value.trim().equals("no")) {
            System.out.println("goodbye!");
            System.exit(1);
            return;
        }
        return;
    }

    public void next() {
        String value;
        while(true) {
            value = scanner.nextLine();
            if(value.trim().equals("")) {
                break;
            }
        }
    }
}


