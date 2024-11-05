package se.oscar.adventure;

public class GameState {
    private static GameState instance;
    private String currentRoom;

    private GameState() {
        this.currentRoom = "LIVING_ROOM";
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String room) {
        this.currentRoom = room;
    }
}
