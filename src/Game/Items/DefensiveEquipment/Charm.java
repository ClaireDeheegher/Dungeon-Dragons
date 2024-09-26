package Game.Items.DefensiveEquipment;

public class Charm extends DefensiveWeapon {

    // /////////////////////  Attributes  //////////////////////// //

    private String charmName = "Charme";
    private int charmLevel = 1;

    // /////////////////////  Constructors  ///////////////////// //
    public Charm() {}

    public Charm(String charmName, int charmLevel) {
        this.charmName = charmName;
        this.charmLevel = charmLevel;
    }
    // /////////////////////  Getters  ///////////////////// //
    public String getPotionName() {
        return charmName;
    }
    public int getPotionLevel() {
        return charmLevel;
    }
    // /////////////////////  Setters  ///////////////////// //
    public void setCharmName(String charmName) {
        this.charmName = charmName;
    }
    public void setCharmLevel(int charmLevel) {
        this.charmLevel = charmLevel;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Charme{" +
                "charmName='" + charmName + '\'' +
                ", charmLevel=" + charmLevel +
                '}';
    }
}
