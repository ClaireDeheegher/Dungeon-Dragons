package fr.campus.dnd.game.items.offensiveEquipment;

import fr.campus.dnd.game.items.Item;

public abstract class OffensiveWeapon extends Item {

    // /////////////////////  Attributes  ///////////////////// //

    private String type;
    private int level;
    private int damage;

    // /////////////////////  Constructors  ///////////////////// //

    OffensiveWeapon(){
    this.setName("");
    }



    // /////////////////////  Getters-Setters  ///////////////////// //

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }


    // /////////////////////  Methods  ///////////////////// //


    @Override
    public String toString() {
        return "OffensiveWeapon{" +
                "type='" + type + '\'' +
                ", level=" + level +
                ", damage=" + damage +
                '}';
    }
}
