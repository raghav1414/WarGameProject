/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

public class WarGame extends Game {
    private WarPlayer player1;
    private WarPlayer player2;

    public WarGame(String name, WarPlayer p1, WarPlayer p2) {
        super(name);
        this.player1 = p1;
        this.player2 = p2;
    }

    @Override
    public void play() {
        System.out.println("War Game Started...\n");

        int round = 1;

        while (player1.hasCards() && player2.hasCards()) {
            System.out.println("Round " + round);
            System.out.println(player1.getName() + " has " + player1.getDeck().getCards().size() + " cards.");
            System.out.println(player2.getName() + " has " + player2.getDeck().getCards().size() + " cards.");

            WarCard card1 = player1.playCard();
            WarCard card2 = player2.playCard();

            if (card1 == null || card2 == null) {
                System.out.println("A player has no more cards. Ending game.");
                break;
            }

            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            if (card1.getRank() > card2.getRank()) {
                System.out.println(player1.getName() + " wins the round!\n");
                player1.getDeck().addCard(card1);
                player1.getDeck().addCard(card2);
            } else if (card1.getRank() < card2.getRank()) {
                System.out.println(player2.getName() + " wins the round!\n");
                player2.getDeck().addCard(card1);
                player2.getDeck().addCard(card2);
            } else {
                System.out.println("It's a tie! WAR begins...\n");
                handleWar();
            }

            round++;

            
            if (round > 100) {
                System.out.println("Game stopping after 100 rounds to prevent infinite loop.");
                break;
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        System.out.println("\nGame Over!");
        if (player1.hasCards()) {
            System.out.println(player1.getName() + " wins the game!");
        } else {
            System.out.println(player2.getName() + " wins the game!");
        }
    }

    private void handleWar() {
        if (player1.getDeck().getCards().size() < 4 || player2.getDeck().getCards().size() < 4) {
            System.out.println("Not enough cards for War. Game ends.");
            return;
        }

        WarCard warCard1 = player1.playCard();
        WarCard warCard2 = player2.playCard();

        System.out.println(player1.getName() + " places a war card: " + warCard1);
        System.out.println(player2.getName() + " places a war card: " + warCard2);

        if (warCard1.getRank() > warCard2.getRank()) {
            System.out.println(player1.getName() + " wins the War round!\n");
            player1.getDeck().addCard(warCard1);
            player1.getDeck().addCard(warCard2);
        } else {
            System.out.println(player2.getName() + " wins the War round!\n");
            player2.getDeck().addCard(warCard1);
            player2.getDeck().addCard(warCard2);
        }
    }
}


