package Game.Character_settings;

public class Magician extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private Spell spell = new Spell();
    private Potion potion = new Potion();

    // /////////////////////  Constructors  ///////////////////// //

    public Magician(String name) {
        super(name);
        this.setLifePoints(6);
        this.setStrength(15);
        this.setJob("Magicien");
    }

    // /////////////////////  Getters  ///////////////////// //


    public Potion getPotion() {
        return potion;
    }
    public Spell getSpell() {
        return spell;
    }

    // /////////////////////  Setters  ///////////////////// //


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
                ", spell=" + spell +
                ", potion=" + potion +
                '}';
    }

    @Override
    public void showCharacter() {
        super.showCharacter();
        System.out.println(potion.toString());
        System.out.println(spell.toString());
    }
}
