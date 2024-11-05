package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;

public class Bedroom implements Room {
    GameState gameState = GameState.getInstance();

    @Override
    public void description() {
        System.out.println("""
                The bedroom is dark and messy from the night before. you must've forgot to make the bed
                Theres nothing you see that can help in here""");
    }

    @Override
    public void enter() {
        System.out.println("You enter the bedroom");
        gameState.setCurrentRoom("BEDROOM");
    }
}
