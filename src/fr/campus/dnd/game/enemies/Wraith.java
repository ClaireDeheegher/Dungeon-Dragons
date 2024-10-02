package fr.campus.dnd.game.enemies;

public class Wraith extends Enemy implements IsFriend{
    public Wraith() {
        this.setEnemyName("Wraith");
        this.setEnemyHealth(15);
        this.setEnemyDamage(5);
        this.setXp(100);
        this.getFriendlyJobs().add("Warrior");
        this.getFriendlyJobs().add("Hunter");
    }
}
