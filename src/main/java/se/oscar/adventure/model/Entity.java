package se.oscar.adventure.model;

public abstract class Entity {
    private final String role;
    private int health;
    int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void punch(Entity toPunch) {
        toPunch.takeDamage(this.damage);
    }

    public boolean isConscious() {
        return this.health > 0;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
