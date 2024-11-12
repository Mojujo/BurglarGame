package se.oscar.adventure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.oscar.adventure.model.Burglar;
import se.oscar.adventure.model.Resident;

import static org.junit.Assert.*;

public class EntityTest {
    Resident player;
    Burglar intruder;

    @Before
    public void setUp() {
        player = new Resident("Resident", 4, 3);
        intruder = new Burglar("Burglar", 4, 4);
    }

    @After
    public void tearDown() {
        player = null;
        intruder = null;
    }

    ///////////
    // Tests //
    ///////////

    @Test
    public void testPunch() {
        player.punch(intruder);
        assertEquals(1, intruder.getHealth());
    }

    @Test
    public void testTakeDamage() {
        intruder.takeDamage(3);
        assertEquals(1, intruder.getHealth());
    }

    @Test
    public void testIsConscious() {
        player.isConscious();
        assertTrue(player.isConscious());

        intruder.punch(player);
        assertFalse(player.isConscious());
    }
}
