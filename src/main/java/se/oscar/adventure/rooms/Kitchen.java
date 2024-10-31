package se.oscar.adventure.rooms;

import se.oscar.adventure.model.Entity;

public class Kitchen implements Room {
    @Override
    public void description() {
        System.out.println("Kitchen description");
    }

    @Override
    public void enter(Entity entity) {
        System.out.println("Kitchen entered");
    }
}
