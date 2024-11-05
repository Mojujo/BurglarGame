package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;

public class LivingRoom implements Room {
    GameState gameState = GameState.getInstance();

    @Override
    public void description() {
        System.out.println("The living room description");
    }

    @Override
    public void enter() {
        System.out.println("You enter the living room");
        gameState.setCurrentRoom("LIVING_ROOM");
    }
}
