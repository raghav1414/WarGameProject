/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;  

import java.util.ArrayList;
import java.util.Collections;  


import ca.sheridancollege.project.WarDeck;
import ca.sheridancollege.project.WarCard;
import ca.sheridancollege.project.WarPlayer;
import ca.sheridancollege.project.WarGame;

public class WarMain {
    public static void main(String[] args) {
        System.out.println("WarMain started executing...");

        WarDeck deck1 = new WarDeck(26);
        WarDeck deck2 = new WarDeck(26);

        System.out.println("WarDeck objects created.");

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        ArrayList<WarCard> allCards = new ArrayList<>();

        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                allCards.add(new WarCard(suit, rank));
            }
        }

        Collections.shuffle(allCards);

        for (int i = 0; i < allCards.size(); i++) {
            if (i % 2 == 0) deck1.addCard(allCards.get(i));
            else deck2.addCard(allCards.get(i));
        }

        WarPlayer player1 = new WarPlayer("Player 1", deck1);
        WarPlayer player2 = new WarPlayer("Player 2", deck2);

        System.out.println("WarPlayer objects created.");

        WarGame game = new WarGame("War", player1, player2);
        System.out.println("WarGame object created. Starting game...");

        game.play();
        System.out.println("WarMain execution completed.");
    }
}


