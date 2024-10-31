package se.oscar.adventure.model;

public class Resident extends Entity {
    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public void setDamage(int damageInput) {
        damage = damageInput;
    }
}
