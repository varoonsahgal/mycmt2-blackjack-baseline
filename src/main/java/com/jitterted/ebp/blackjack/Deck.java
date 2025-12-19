package com.jitterted.ebp.blackjack;
// Deck is a nice PURE domain class
// it has no dependencies on INFRA

//how do you tell if a class is PURE domain?
// if you are importing a library that deals with IO (like Ansi in the Card class)
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }

    public Card draw() {
        return cards.remove(0);
    }
}
