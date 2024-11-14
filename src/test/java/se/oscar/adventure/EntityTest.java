package se.oscar.adventure;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import se.oscar.adventure.model.Burglar;
import se.oscar.adventure.model.Resident;

class EntityTest {
    Resident player;
    Burglar intruder;

    @BeforeEach
    public void setUp() {
        player = new Resident("Resident", 4, 3);
        intruder = new Burglar("Burglar", 4, 4);
    }

    @AfterEach
    public void tearDown() {
        player = null;
        intruder = null;
    }

    ///////////
    // Tests //
    ///////////

    @Test
    void testPunch() {
        player.punch(intruder);
        Assertions.assertEquals(1, intruder.getHealth());
    }

    @Test
    public void testTakeDamage() {
        intruder.takeDamage(3);
        Assertions.assertEquals(1, intruder.getHealth());
    }

    @Test
    public void testIsConscious() {
        player.isConscious();
        Assertions.assertTrue(player.isConscious());

        intruder.punch(player);
        Assertions.assertFalse(player.isConscious());
    }
}
