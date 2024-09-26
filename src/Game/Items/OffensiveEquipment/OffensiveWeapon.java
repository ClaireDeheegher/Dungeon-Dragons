package Game.Items.OffensiveEquipment;

import Game.Items.Item;

public abstract class OffensiveWeapon extends Item {

    // /////////////////////  Attributes  ///////////////////// //

    private String offensiveWeaponType;
    private int offensiveWeaponLevel;

    // /////////////////////  Constructors  ///////////////////// //

    OffensiveWeapon(){
    this.setName("");
    }



    // /////////////////////  Getters  ///////////////////// //

    public String getOffensiveWeaponType() {
        return offensiveWeaponType;
    }
    public int getOffensiveWeaponLevel() {
        return offensiveWeaponLevel;
    }

    // /////////////////////  Setters  ///////////////////// //

    public void setOffensiveWeaponType(String offensiveWeaponType) {
        this.offensiveWeaponType = offensiveWeaponType;
    }
    public void setOffensiveWeaponLevel(int offensiveWeaponLevel) {
        this.offensiveWeaponLevel = offensiveWeaponLevel;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "OffensiveWeapon{" +
                "offensiveWeaponType='" + offensiveWeaponType + '\'' +
                ", offensiveWeaponLevel=" + offensiveWeaponLevel +
                '}';
    }
}
