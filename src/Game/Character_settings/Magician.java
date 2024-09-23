package Game.Character_settings;

public class Magician extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private int lifePoints = 6;
    private int strength = 15;
    private Spell spell;
    private Potion potion;

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
    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Magician{" +
                "lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", spell=" + spell +
                ", potion=" + potion +
                '}';
    }
}
