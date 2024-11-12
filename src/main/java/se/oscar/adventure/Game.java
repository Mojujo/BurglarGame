package se.oscar.adventure;

import se.oscar.adventure.model.Burglar;
import se.oscar.adventure.model.Entity;
import se.oscar.adventure.model.Resident;
import se.oscar.adventure.rooms.*;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    private Resident player;
    private Burglar intruder;
    private boolean run = true;
    private final Scanner scanner = new Scanner(System.in);
    private final GameState gameState = GameState.getInstance();
    private final Kitchen kitchen = new Kitchen();
    private final Bedroom bedroom = new Bedroom();
    private final Hallway hallway = new Hallway();
    private final LivingRoom livingRoom = new LivingRoom();
    private final Office office = new Office();


    public void start() {
        while (run && player.isConscious() && !office.policeCalled()) {
            nextMove();
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
                    Take out the burglar and contact the authorities as quick as you can!
                    Commands include: 'kitchen 'bedroom' 'hallway' 'living room' 'office' 'map' 'quit'
                    You can only walk to adjacent locations
                    If your health reaches 0 you lose
                    """);
            map();
            Thread.sleep(1000);
            System.out.println("Do you want to start the game? (y/n)");
            switch (getUserInput()) {
                case "y" -> {
                    player = new Resident("Resident", 12, 3);
                    intruder = new Burglar("Burglar", 12, 4);
                    System.out.println("""
                            
                            You're suddenly awoken by a loud bang coming from the hallway
                            In a haze, you stand up from the couch, looking around the living room, ready to take action.
                            """);
                    System.out.println("Starting the game. . .");
                    Thread.sleep(1000);
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
            case "kitchen" -> kitchen();
            case "bedroom" -> bedroom();
            case "hallway" -> hallway();
            case "living room" -> livingRoom();
            case "office" -> office();
            case "map" -> map();
            case "quit" -> {
                return false;
            }
            default -> System.out.println("Bad input");
        }
        return true;
    }

    private boolean searchInput() {
        System.out.println("Do you want to look around the " + gameState.getCurrentRoom() + "? (search/no) ");
        String choice = getUserInput().toLowerCase();
        return choice.equals("search");
    }

    void executeAttack(Entity attacker, Entity defender) {
        try {
            Thread.sleep(1500);
            attacker.punch(defender);
            System.out.println(attacker.getRole() + " attacks " + defender.getRole() + " for " + attacker.getDamage());
            if (defender.isConscious()) {
                System.out.println(defender.getRole() + " has " + defender.getHealth() + " health left");
            } else {
                System.out.println(defender.getRole() + " has been knocked out!");
            }
        } catch (Exception _) {
        }
    }

    private void fightOneRound() {
        executeAttack(player, intruder);
        if (intruder.isConscious()) {
            executeAttack(intruder, player);
        }
    }

    private void livingRoom() {
        if (!Objects.equals(gameState.getCurrentRoom(), "LIVING_ROOM")) {
            livingRoom.enter();
        } else {
            System.out.println("You cant go there");
        }
    }

    private void kitchen() {
        if (Objects.equals(gameState.getCurrentRoom(), "LIVING_ROOM")) {
            kitchen.enter();
            if (searchInput()) {
                kitchen.search(scanner, player);
            }
        } else {
            System.out.println("You cant go there");
        }
    }

    private void bedroom() {
        if (Objects.equals(gameState.getCurrentRoom(), "LIVING_ROOM")) {
            bedroom.enter();
            if (searchInput()) {
                bedroom.description();
            }
        } else {
            System.out.println("You cant go there");
        }
    }

    private void hallway() {
        if (Objects.equals(gameState.getCurrentRoom(), "LIVING_ROOM")) {
            hallway.enter();
            if (intruder.isConscious()) {
                hallway.description();
                System.out.println("No time to waste, you lunge at the intruder! ");
                while (player.isConscious() && intruder.isConscious()) {
                    fightOneRound();
                }
            } else {
                System.out.println("The burglar is laid out on the floor");
            }
        } else {
            System.out.println("You cant go there");
        }
    }

    private void office() {
        if (Objects.equals(gameState.getCurrentRoom(), "LIVING_ROOM")) {
            office.enter();
            if (searchInput()) {
                office.search(scanner, intruder);
            }
        } else {
            System.out.println("You cant go there");
        }
    }

    private void nextMove() {
        System.out.println("----------------------------------------");
        System.out.println("Which room do you want to go to?");
    }

    private void map() {
        System.out.println("""
                Map:
                ___________________________________
                |             Kitchen             |
                |                |                |
                |Bedroom -- Living Room -- Hallway|
                |                |                |
                |             Office              |
                |_________________________________|""");
        System.out.println("You are in the: " + gameState.getCurrentRoom().toLowerCase());
    }
}
