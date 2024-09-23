package Game.Character_settings;

public class Magician extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private int lifePoints = 6;
    private int strength = 15;
    private String job = "Magicien";
    private Spell spell = new Spell();
    private Potion potion = new Potion();

    // /////////////////////  Constructors  ///////////////////// //

    public Magician(String name) {
        super(name);
    }

    // /////////////////////  Getters  ///////////////////// //

    @Override
    public int getLifePoints() {
        return lifePoints;
    }
    @Override
    public int getStrength() {
        return strength;
    }
    @Override
    public String getJob() {
        return job;
    }
    public Potion getPotion() {
        return potion;
    }
    public Spell getSpell() {
        return spell;
    }

    // /////////////////////  Setters  ///////////////////// //

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setPotion(Potion potion) {
        this.potion = potion;
    }
    @Override
    public void setJob(String job) {
        this.job = job;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    // /////////////////////  Methods  ///////////////////// //


    @Override
    public String toString() {
        return "Magician{" +
                "lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", job='" + job + '\'' +
                ", spell=" + spell +
                ", potion=" + potion +
                '}';
    }

    @Override
    public void showCharacter() {
        super.showCharacter();
        System.out.println("Job : "+ job);
        System.out.println("Points de vie : " +lifePoints);
        System.out.println("Dégâts : " +strength);
        System.out.println(potion.toString());
        System.out.println(spell.toString());
    }
}
