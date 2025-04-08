package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

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

            List<WarCard> roundCards = new ArrayList<>();
            roundCards.add(card1);
            roundCards.add(card2);

            if (card1.getRank() > card2.getRank()) {
                System.out.println(player1.getName() + " wins the round!\n");
                player1.addCards(roundCards);
            } else if (card1.getRank() < card2.getRank()) {
                System.out.println(player2.getName() + " wins the round!\n");
                player2.addCards(roundCards);
            } else {
                System.out.println("It's a tie! WAR begins...\n");
                roundCards.addAll(handleWar());
                
                if (!player1.hasCards() || !player2.hasCards()) break;
                WarCard warCard1 = player1.playCard();
                WarCard warCard2 = player2.playCard();
                roundCards.add(warCard1);
                roundCards.add(warCard2);

                System.out.println(player1.getName() + " WAR card: " + warCard1);
                System.out.println(player2.getName() + " WAR card: " + warCard2);

                if (warCard1.getRank() > warCard2.getRank()) {
                    System.out.println(player1.getName() + " wins the war!\n");
                    player1.addCards(roundCards);
                } else if (warCard1.getRank() < warCard2.getRank()) {
                    System.out.println(player2.getName() + " wins the war!\n");
                    player2.addCards(roundCards);
                } else {
                    System.out.println("Another tie! No further war logic implemented.\n");
                }
            }

            round++;
            if (round > 100) {
                System.out.println("Stopping after 100 rounds to prevent infinite loop.");
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

    private List<WarCard> handleWar() {
        List<WarCard> warPile = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (player1.hasCards()) warPile.add(player1.playCard());
            if (player2.hasCards()) warPile.add(player2.playCard());
        }

        return warPile;
    }
}
