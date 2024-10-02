package fr.campus.dnd.game.enemies;

public class Orc extends Enemy implements IsFriend{
    public Orc(){
        this.setEnemyName("Orc");
        this.setEnemyHealth(10);
        this.setEnemyDamage(6);
        this.setXp(100);
        this.getFriendlyJobs().add("Magician");
        this.getFriendlyJobs().add("Hunter");
    }
}
