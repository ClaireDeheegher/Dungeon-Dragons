package fr.campus.dnd.game.items.defensiveEquipment;

import fr.campus.dnd.game.items.Item;

public abstract class DefensiveWeapon extends Item {

    // /////////////////////  Attributes  ///////////////////// //

    private String defensiveWeaponType;
    private int defensiveWeaponLevel;

    // /////////////////////  Constructor ///////////////////// //

    public DefensiveWeapon(){
        this.setName("");
    }

    // /////////////////////  Getters  ///////////////////// //


    public String getDefensiveWeaponType() {
        return defensiveWeaponType;
    }
    public int getDefensiveWeaponLevel() {
        return defensiveWeaponLevel;
    }

    // /////////////////////  Setters  ///////////////////// //


    public void setDefensiveWeaponType(String defensiveWeaponType) {
        this.defensiveWeaponType = defensiveWeaponType;
    }
    public void setDefensiveWeaponLevel(int defensiveWeaponLevel) {
        this.defensiveWeaponLevel = defensiveWeaponLevel;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "DefensiveWeapon{" +
                "defensiveWeaponType='" + defensiveWeaponType + '\'' +
                ", defensiveWeaponLevel=" + defensiveWeaponLevel +
                '}';
    }
}
