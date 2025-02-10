/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

public class WarPlayer extends Player {
    private WarDeck deck;

    public WarPlayer(String name, WarDeck deck) {
        super(name);
        this.deck = deck;
    }

    public WarCard playCard() {
        return deck.drawCard();
    }

    public boolean hasCards() {
        return !deck.getCards().isEmpty();
    }

    public WarDeck getDeck() {
        return deck;
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing their turn.");
        WarCard playedCard = playCard();

        if (playedCard != null) {
            System.out.println(getName() + " played: " + playedCard);
        } else {
            System.out.println(getName() + " has no more cards to play.");
        }
    }
}
