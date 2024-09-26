package Game.Characters;

import Game.Items.DefensiveEquipment.Charm;
import Game.Items.OffensiveEquipment.Spell;

public class Magician extends Character {

    // /////////////////////  Attributes  //////////////////////// //

    private Spell spell = new Spell();
    private Charm charm = new Charm();

    // /////////////////////  Constructors  ///////////////////// //

    public Magician(String name) {
        super(name);
        this.setLifePoints(6);
        this.setStrength(15);
        this.setJob("Magicien");
    }

    // /////////////////////  Getters  ///////////////////// //


    public Charm getPotion() {
        return charm;
    }
    public Spell getSpell() {
        return spell;
    }

    // /////////////////////  Setters  ///////////////////// //


    public void setPotion(Charm charm) {
        this.charm = charm;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    // /////////////////////  Methods  ///////////////////// //


    @Override
    public String toString() {
        return "Magician{" +
                ", spell=" + spell +
                ", potion=" + charm +
                '}';
    }

    @Override
    public void showCharacter() {
        super.showCharacter();
        System.out.println(charm.toString());
        System.out.println(spell.toString());
    }
}
