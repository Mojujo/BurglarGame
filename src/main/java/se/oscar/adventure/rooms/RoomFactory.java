package se.oscar.adventure.rooms;

public class RoomFactory {
    public static Room createRoom(String roomType) {
        return switch (roomType) {
            case "KITCHEN" -> new Kitchen();
            case "LIVING_ROOM" -> new LivingRoom();
            case "BEDROOM" -> new Bedroom();
            case "OFFICE" -> new Office();
            case "HALLWAY" -> new Hallway();
            default -> throw new IllegalArgumentException("Invalid room type" + roomType);
        };
    }
}
