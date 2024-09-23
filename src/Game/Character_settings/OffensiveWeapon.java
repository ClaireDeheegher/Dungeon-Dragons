package Game.Character_settings;

public class OffensiveWeapon {

    // /////////////////////  Attributes  ///////////////////// //

    private String offensiveWeaponType;
    private String offensiveWeaponName;
    private int offensiveWeaponLevel;

    // /////////////////////  Constructors  ///////////////////// //

    OffensiveWeapon(){

    }

    OffensiveWeapon(String weaponName, String weaponType, int level) {
        this.offensiveWeaponLevel = level;
        this.offensiveWeaponName = weaponName;
        this.offensiveWeaponType = weaponType;
    }

    // /////////////////////  Getters  ///////////////////// //

    public String getOffensiveWeaponName() {
        return offensiveWeaponName;
    }
    public String getOffensiveWeaponType() {
        return offensiveWeaponType;
    }
    public int getOffensiveWeaponLevel() {
        return offensiveWeaponLevel;
    }

    // /////////////////////  Setters  ///////////////////// //

    public void setOffensiveWeaponName(String offensiveWeaponName) {
        this.offensiveWeaponName = offensiveWeaponName;
    }
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
                ", offensiveWeaponName='" + offensiveWeaponName + '\'' +
                ", offensiveWeaponLevel=" + offensiveWeaponLevel +
                '}';
    }
}
