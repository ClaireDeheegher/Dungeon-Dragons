package Game.Character_settings;

public class Shield extends DefensiveWeapon{

    // /////////////////////  Attributes  //////////////////////// //

    private String shieldName;
    private int shieldLevel;

    // /////////////////////  Constructors  ///////////////////// //

    public Shield(){
    }

    public Shield(String name, int level){
        this.shieldName = name;
        this.shieldLevel = level;
    }
    // /////////////////////  Getters  ///////////////////// //

    public String getShieldName() {
        return shieldName;
    }
    public int getShieldLevel() {
        return shieldLevel;
    }

    // /////////////////////  Setters  ///////////////////// //

    public void setShieldName(String shieldName) {
        this.shieldName = shieldName;
    }

    public void setShieldLevel(int shieldLevel) {
        this.shieldLevel = shieldLevel;
    }
    // /////////////////////  Methods  ///////////////////// //


    @Override
    public String toString() {
        return "Shield{" +
                "shieldName='" + shieldName + '\'' +
                ", shieldLevel=" + shieldLevel +
                '}';
    }
}
