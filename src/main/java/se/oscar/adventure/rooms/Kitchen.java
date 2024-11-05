package se.oscar.adventure.rooms;

import se.oscar.adventure.GameState;
import se.oscar.adventure.model.Entity;

import java.util.Scanner;

public class Kitchen implements Room {
    GameState gameState = GameState.getInstance();
    boolean panFound = false;

    @Override
    public void description() {
        System.out.println("You look around the kitchen, finding dirty pots and utensils.");
        if (!panFound) {
            System.out.println("You also find a frying pan you can reliably swing");
        }
    }

    @Override
    public void enter() {
        System.out.println("You enter the kitchen");
        gameState.setCurrentRoom("KITCHEN");
    }

    public void search(Scanner scanner, Entity entity) {
        description();
        if (!panFound) {
            System.out.println("Do you want to use the frying pan? (y/n)");
            String choice = scanner.nextLine();
            if (choice.equals("y")) {
                entity.setDamage(6);
                panFound = true;
                System.out.println("You wield the frying pan with mighty resolve.");
            }
        }
    }
}
