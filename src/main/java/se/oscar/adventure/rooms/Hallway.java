package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;

public class Hallway implements Room {
    GameState gameState = GameState.getInstance();

    @Override
    public void description() {
        System.out.println("The hallway is dark, but you can make out a figure standing in the hallway, it must be a burglar");
    }

    @Override
    public void enter() {
        System.out.println("You enter the hallway");
        gameState.setCurrentRoom("HALLWAY");
    }
}
