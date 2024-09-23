package Game.Character_settings;

public class Potion extends DefensiveWeapon {

    // /////////////////////  Attributes  //////////////////////// //

    private String potionName;
    private int potionLevel;

    // /////////////////////  Constructors  ///////////////////// //
    public Potion() {}

    public Potion(String potionName, int potionLevel) {
        this.potionName = potionName;
        this.potionLevel = potionLevel;
    }
    // /////////////////////  Getters  ///////////////////// //
    public String getPotionName() {
        return potionName;
    }
    public int getPotionLevel() {
        return potionLevel;
    }
    // /////////////////////  Setters  ///////////////////// //
    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }
    public void setPotionLevel(int potionLevel) {
        this.potionLevel = potionLevel;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Potion{" +
                "potionName='" + potionName + '\'' +
                ", potionLevel=" + potionLevel +
                '}';
    }
}
