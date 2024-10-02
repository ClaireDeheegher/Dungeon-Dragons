package fr.campus.dnd.game.items;

import java.util.ArrayList;

public class Inventory {
    // /////////////////////  Attributes  //////////////////////// //

    private ArrayList<Item> inventory= new ArrayList<Item>();

    // /////////////////////  Constructors  ///////////////////// //

    public Inventory() {}

    // /////////////////////  Getters/Setters  ///////////////////// //

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
    }
}
