package Game.Character_settings;

public class Warrior extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private int lifePoints = 10;
    private int strength = 10;
    private String job = "Guerrier";
    private Weapon weapon = new Weapon();
    private Shield shield = new Shield();

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

    @Override
    public String getJob() {
        return job;
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

    @Override
    public void setJob(String job) {
        this.job = job;
    }
    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Warrior{" +
                "lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", job='" + job +
                ", weapon=" + weapon +
                ", shield=" + shield +
                '}';
    }
    @Override
    public void showCharacter() {
        super.showCharacter();
        System.out.println("Job : "+ job);
        System.out.println("Points de vie : " +lifePoints);
        System.out.println("Dégâts : " +strength);
        System.out.println(weapon.toString());
        System.out.println(shield.toString());
    }
}
