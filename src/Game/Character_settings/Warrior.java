package Game.Character_settings;

public class Warrior extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private Weapon weapon = new Weapon();
    private Shield shield = new Shield();

    // /////////////////////  Constructors  ///////////////////// //

    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setJob("Guerrier");
        this.setLifePoints(10);

    }

    // /////////////////////  Getters  ///////////////////// //



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

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Warrior{" +
                ", weapon=" + weapon +
                ", shield=" + shield +
                '}';
    }
    @Override
    public void showCharacter() {
        super.showCharacter();
        System.out.println(weapon.toString());
        System.out.println(shield.toString());
    }
}
