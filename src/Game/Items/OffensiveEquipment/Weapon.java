package Game.Items.OffensiveEquipment;

public class Weapon extends OffensiveWeapon {

    // /////////////////////  Attributes  //////////////////////// //


    private int weaponLevel;
    private int weaponDamage;

    // /////////////////////  Constructors  ///////////////////// //

    public Weapon(){
        this.setName("");
    }



    // /////////////////////  Getters  ///////////////////// //

    public int getWeaponLevel() {
        return weaponLevel;
    }
    public int getWeaponDamage(){return weaponDamage;}

    // /////////////////////  Setters  ///////////////////// //

    public void setWeaponLevel(int weaponLevel) {this.weaponLevel = weaponLevel;}
    public void setWeaponDamage(int weaponDamage) {this.weaponDamage = weaponDamage;}

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Weapon{" +
                ", weaponLevel=" + weaponLevel +
                ", weaponDamage=" + weaponDamage +
                '}';
    }
}
