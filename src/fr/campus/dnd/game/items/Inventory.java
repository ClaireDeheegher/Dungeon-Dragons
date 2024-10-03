package fr.campus.dnd.game.items;

import java.util.ArrayList;

public class Inventory {
    // /////////////////////  Attributes  //////////////////////// //

    private ArrayList<Item> inventory= new ArrayList<Item>();
    private boolean isFull = false;

    // /////////////////////  Constructors  ///////////////////// //

    public Inventory() {}

    // /////////////////////  Getters/Setters  ///////////////////// //

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public boolean isFull() {
        return isFull;
    }
    public void setFull(boolean full) {
        this.isFull = full;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
    }
    public void addItem(Item item) {
        inventory.add(item);
    }
    public void useItem(Item item) {
        inventory.remove(item);
    }
    public boolean checkIfSpace(){
        if(inventory.size()==10){
            isFull = true;
        }
        return isFull;
    }
}
