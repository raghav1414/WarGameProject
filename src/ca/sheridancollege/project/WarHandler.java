/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.*;

public class WarHandler {
    public static List<WarCard> executeWar(WarPlayer p1, WarPlayer p2) {
        List<WarCard> warPile = new ArrayList<>();

        
        for (int i = 0; i < 3; i++) {
            if (p1.hasCards()) warPile.add(p1.playCard());
            if (p2.hasCards()) warPile.add(p2.playCard());
        }

        return warPile;
    }
}

