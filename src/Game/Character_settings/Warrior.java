package Game.Character_settings;

public class Warrior extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private int lifePoints = 10;
    private int strength = 10;
    private Weapon weapon;
    private Shield shield;

    // /////////////////////  Constructors  ///////////////////// //

    public Warrior(String name) {
        super(name);
    }

    // /////////////////////  Getters  ///////////////////// //

    @Override
    public int getStrength() {
        return strength;
    }
    @Override
    public int getLifePoints() {
        return lifePoints;
    }
    public Shield getShield() {
        return shield;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    // /////////////////////  Setters  ///////////////////// //

    public void setShield(Shield shield) {
        this.shield = shield;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Warrior{" +
                "lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", weapon=" + weapon +
                ", shield=" + shield +
                '}';
    }
}
