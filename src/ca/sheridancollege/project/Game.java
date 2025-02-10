/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public abstract class Game {
    private final String name;
    private ArrayList<Player> players;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public abstract void play();
    public abstract void declareWinner();
}
