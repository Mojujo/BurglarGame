package se.oscar.adventure.rooms;

import se.oscar.adventure.model.Entity;

public interface Room {
    void description();
    void enter(Entity entity);
}
