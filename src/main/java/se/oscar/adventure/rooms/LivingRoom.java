package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;

public class LivingRoom implements Room {
    GameState gameState = GameState.getInstance();

    @Override
    public void description() {
        System.out.println("Its as messy as you left it");
    }

    @Override
    public void enter() {
        System.out.println("You enter the living room");
        description();
        gameState.setCurrentRoom("LIVING_ROOM");
    }
}
