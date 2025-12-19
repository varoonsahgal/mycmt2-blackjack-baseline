package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDisplayTest {

    public static final Suit DUMMY_SUIT = Suit.HEARTS;

    //WHY write this test in the first place?
    // we want to make sure we do NOT break existing behavior while refactoring - while modifying
    // the card class to get rid of the display logic!
    // think of this test like a SAFETY NET!!
    @Test
    public void displayTenAsString() throws Exception {
        // here we do NOT care which SUIT gets used
        Card card = new Card(DUMMY_SUIT, Rank.TEN);

        //why bother writing a failed test first?
        //because: you dont want to trust a test that has never failed...
        //AND we dont really know what hte output should be initially
        assertThat(ConsoleCard.display(card))
                .isEqualTo("\u001B[31m┌─────────┐\u001B[1B\u001B[11D│10       │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♥    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│       10│\u001B[1B\u001B[11D└─────────┘");
    }


    @Test
    public void displayNonTenAsString() throws Exception {
        // here we do NOT care which SUIT gets used
        Card card = new Card(DUMMY_SUIT, Rank.QUEEN);

        //why bother writing a failed test first?
        //because: you dont want to trust a test that has never failed...
        //AND we dont really know what hte output should be initially
        assertThat(ConsoleCard.display(card))
                .isEqualTo("\u001B[31m┌─────────┐\u001B[1B\u001B[11D│Q        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♥    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        Q│\u001B[1B\u001B[11D└─────────┘");
    }
}