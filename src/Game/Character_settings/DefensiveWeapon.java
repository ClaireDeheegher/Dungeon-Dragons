package Game.Character_settings;

public class DefensiveWeapon {

    // /////////////////////  Attributes  ///////////////////// //

    private String defensiveWeaponType;
    private String defensiveWeaponName;
    private int defensiveWeaponLevel;

    // /////////////////////  Constructor ///////////////////// //

    DefensiveWeapon(){

    }

    DefensiveWeapon(String weaponName, String weaponType, int level){
        this.defensiveWeaponLevel = level;
        this.defensiveWeaponName = weaponName;
        this.defensiveWeaponType = weaponType;
    }

    // /////////////////////  Getters  ///////////////////// //

    public String getDefensiveWeaponName() {
        return defensiveWeaponName;
    }
    public String getDefensiveWeaponType() {
        return defensiveWeaponType;
    }
    public int getDefensiveWeaponLevel() {
        return defensiveWeaponLevel;
    }

    // /////////////////////  Setters  ///////////////////// //

    public void setDefensiveWeaponName(String defensiveWeaponName) {
        this.defensiveWeaponName = defensiveWeaponName;
    }
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
                ", defensiveWeaponName='" + defensiveWeaponName + '\'' +
                ", defensiveWeaponLevel=" + defensiveWeaponLevel +
                '}';
    }
}
