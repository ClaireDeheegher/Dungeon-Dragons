package fr.campus.dnd.game.items.consumable;

import fr.campus.dnd.game.items.Item;

public class Potion extends Item {
    // /////////////////////  Attributes  //////////////////////// //
    private int regenHP;

    // /////////////////////  Constructors  //////////////////////// //
    public Potion(){
        this.regenHP = 0;
        this.setName("Potion");
    }

    // /////////////////////  Getter  //////////////////////// //

    public int getRegenHP() {
        return regenHP;
    }

    // /////////////////////  Setter  //////////////////////// //

    public void setRegenHP(int regenHP) {
        this.regenHP = regenHP;
    }

    // /////////////////////  Methods  //////////////////////// //

    @Override
    public String toString() {
        return "Potion{" +
                "regenHP=" + regenHP +
                '}';
    }
}
