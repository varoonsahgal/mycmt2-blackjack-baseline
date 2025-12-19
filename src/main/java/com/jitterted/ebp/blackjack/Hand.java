package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Hand() {
    }

    public int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }


//why do i want to MOVE this method?
    // because it "knows" about the display - and the Hand class
    // really should NOT know anything about display in the console - if i want to
    // play BJ on the web, now this is a problem
    // Hand should only be concerned with how to represent a HAND in blackjack


    //Why do i want to make this method static?  So it easier to move to another
    // class where it belongs

    public Card dealerFaceUpCard() {
        return cards.get(0);
    }

    boolean dealerMustDrawCard() {
        return value() <= 16;
    }

    public List<Card> cards() {
        return new ArrayList<>(cards);
    }

    public void drawFrom(Deck deck) {
        cards.add(deck.draw());
    }

    boolean isBusted() {
        return value() > 21;
    }

    boolean pushes(Hand hand) {
        return hand.value() == value();
    }

    boolean beats(Hand hand) {
        return hand.value() < value();
    }

    public boolean valueEquals(int target) {
        return value() == target;
    }
}
