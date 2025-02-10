/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

public class WarDeck extends GroupOfCards {
    public WarDeck(int size) {
        super(size);
    }

    public void addCard(WarCard card) {
        cards.add(card);
    }

    public WarCard drawCard() {
        if (!cards.isEmpty()) {
            return (WarCard) cards.remove(0);
        }
        return null;
    }
}

