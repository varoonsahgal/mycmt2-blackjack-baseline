package com.jitterted.ebp.blackjack;

// these 2 imports ONLY work for the console view
// what if we wanted to use a Spring WEB view

import static org.fusesource.jansi.Ansi.ansi;

// Architecturally Card should ONLY be focused on representing Card in the game of blackjack
// what properties Card has in blackjack and what business rules apply to it!
// ideally it should not have any knowledge of the outside world
// BUT this class is TIGHTLY coupled with the CONSOLE right now
// what if i wanted to play the game in a browser - on the web??
// changing this class would be a PAIN!!!

//TLDR; this class mixes domain logic with PRESENTATIon infrastrucre via the Ansi dependencies!
// also violates single repsonsibility principle: card has 2 reasons to change:
// 1. Rules of blackjack change and 2. UI changes

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int rankValue() {
        return rank.value();
    }

    //I WANT TO MOVE DISPLAY TO ANOTEHR CLASS TO PURIFY CARD
    //SO I NEED TO GET RID OF DIRECT REFERENCES TO CLASS VARIABLES since this method
    // is no longer going to be part of this class, HENCE I CREATE "QUERY METHODS"
    // FOR RANK AND SUIT

    public Suit suit() {
        return suit;
    }

    public Rank rank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card {" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!suit.equals(card.suit)) return false;
        return rank.equals(card.rank);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }
}
