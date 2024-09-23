package Game.Character_settings;

public class Weapon extends OffensiveWeapon{

    // /////////////////////  Attributes  //////////////////////// //

    private String weaponName;
    private int weaponLevel;

    // /////////////////////  Constructors  ///////////////////// //

    public Weapon(){
    }

    public Weapon(String name, int level){
        this.weaponName = name;

        this.weaponLevel = level;
    }

    // /////////////////////  Getters  ///////////////////// //

    public int getWeaponLevel() {
        return weaponLevel;
    }
    public String getWeaponName() {
        return weaponName;
    }

    // /////////////////////  Setters  ///////////////////// //

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponName='" + weaponName + '\'' +
                ", weaponLevel=" + weaponLevel +
                '}';
    }
}
