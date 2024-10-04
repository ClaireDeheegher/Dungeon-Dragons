package fr.campus.dnd.game.enemies.boss;

public class Boss {

    // /////////////////////  Attributes  //////////////////////// //

    private String name;
    private int health;
    private int damage;

    // /////////////////////  Constructors  //////////////////////// //

    // /////////////////////  Getter/Setter  //////////////////////// //

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }


    // /////////////////////  Methods  //////////////////////// //


    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}
