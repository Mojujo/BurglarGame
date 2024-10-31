package se.oscar.adventure;

import se.oscar.adventure.model.Burglar;
import se.oscar.adventure.model.Entity;
import se.oscar.adventure.model.Resident;
import se.oscar.adventure.rooms.Room;
import se.oscar.adventure.rooms.RoomFactory;

import java.util.Scanner;

public class Game {
    private final String NORTH = "north";
    private final String SOUTH = "south";
    private final String EAST = "east";
    private final String WEST = "west";
    private final String TOWN_CENTER = "town_center";
    private final String START = "start";
    private String currentLocation = START;
    private Entity player;
    private Entity intruder;
    private boolean run = true;
    private final Scanner scanner = new Scanner(System.in);


    Room kitchen = RoomFactory.createRoom("KITCHEN");

    public void start() {
        townCentre();
        while (run || player.isConscious()) {
            run = processInput();
        }
    }

    public void welcomeMessage() {
        try {
            System.out.println("""
                      *****************************
                      Welcome to the Adventure Game
                      *****************************
                    
                    Instructions:
                    Control the player by typing the action you would like to take
                    Commands include:
                    You can only walk to adjacent locations
                    If your health reaches 0 you lose
                    """);
            Thread.sleep(1000);
            System.out.println("Do you want to start the game? (y/n)");
            switch (getUserInput()) {
                case "y" -> {
                    player = new Resident("Resident", 12, 3);
                    intruder = new Burglar("Burglar", 12, 4);
                    System.out.println("Starting the game. . .");
                    start();
                }
                case "n" -> System.out.println("Perhaps another time.");
                default -> System.out.println("Invalid input.");
            }
        } catch (Exception _) {
        }
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    private boolean processInput() {
        String choice = getUserInput().toLowerCase();
        switch (choice) {
            case "go north" -> north();
            case "go south" -> south();
            case "go east" -> east();
            case "go west" -> west();
            case "go to town" -> townCentre();
            case "quit" -> {
                return false;
            }
            default -> System.out.println("Bad input");
        }
        return true;
    }

    void executeAttack(Entity attacker, Entity defender) {
        attacker.punch(defender);
        System.out.println(attacker.getRole() + " attacks " + defender.getRole() + " for " + attacker.getDamage());
        if (defender.isConscious()) {
            System.out.println(defender.getRole() + " has " + defender.getHealth() + " health left");
        } else {
            System.out.println(defender.getRole() + " has been knocked out!");
        }
    }

    private void fightOneRound() {
        executeAttack(player, intruder);
        if (intruder.isConscious()) {
            executeAttack(intruder, player);
        }
    }

    private void townCentre() {
        if (!currentLocation.equals(TOWN_CENTER)) {
            System.out.println("You enter a bustling town crowded with merchants and adventurers alike.");
            // Town implement
            currentLocation = TOWN_CENTER;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void north() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going north");
            // Encounter implement
            currentLocation = NORTH;

            fightOneRound();

        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void south() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going south");
            // Encounter implement
            currentLocation = SOUTH;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void east() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going east");
            // Encounter implement
            currentLocation = EAST;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void west() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going west");
            // Encounter implement
            currentLocation = WEST;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void nextMove() {
        System.out.println("What do you want to do next?");
    }
}
