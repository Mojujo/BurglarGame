package se.oscar.adventure;

import org.junit.Test;
import se.oscar.adventure.model.Burglar;
import se.oscar.adventure.model.Resident;

import static org.junit.Assert.*;

public class EntityTest {
    Resident player = new Resident("Resident", 4, 3);
    Burglar intruder = new Burglar("Burglar", 4, 4);

    @Test
    public void testPunch() {
        player.punch(intruder);
        assertEquals(1, intruder.getHealth());
    }

    @Test
    public void testTakeDamage() {
        player.takeDamage(3);
        assertEquals(1, player.getHealth());
    }

    @Test
    public void testIsConscious() {
        player.isConscious();
        assertTrue(player.isConscious());

        intruder.punch(player);
        assertFalse(player.isConscious());
    }
}
