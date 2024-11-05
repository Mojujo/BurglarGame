package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;

public class Hallway implements Room {
    GameState gameState = GameState.getInstance();

    @Override
    public void description() {
        System.out.println("hallway description");
    }

    @Override
    public void enter() {
        System.out.println("You enter the hallway");
        gameState.setCurrentRoom("HALLWAY");
    }
}
