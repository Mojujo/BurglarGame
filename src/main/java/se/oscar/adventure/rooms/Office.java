package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;
import se.oscar.adventure.model.Entity;

import java.util.Scanner;

public class Office implements Room {
    GameState gameState = GameState.getInstance();
    boolean callMade = false;

    @Override
    public void description() {
        System.out.println("""
                Theres stacks of paper, files and folders scattered on the desk
                Your mobile phone must be here somewhere, but theres no time to look around thoroughly
                """);
    }

    @Override
    public void enter() {
        System.out.println("You enter the office");
        gameState.setCurrentRoom("OFFICE");
    }

    public void search(Scanner scanner, Entity entity) {
        description();

        if (!entity.isConscious()) {
            System.out.println("""
                    With the burglar down you have enough time to find your phone in one of the drawers
                    What number do you want to dial?
                    """);
            String choice = scanner.nextLine();
            if (choice.equals("112") || choice.equals("911")) {
                System.out.println("You call the authorities. They're on the way.");
                callMade = true;
            }
        }
    }

    public boolean policeCalled() {
        return callMade;
    }
}
