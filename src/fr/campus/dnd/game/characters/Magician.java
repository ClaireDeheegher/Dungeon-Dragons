package fr.campus.dnd.game.characters;

import fr.campus.dnd.game.items.defensiveEquipment.Charm;
import fr.campus.dnd.game.items.offensiveEquipment.Spell;

public class Magician extends Character {

    // /////////////////////  Attributes  //////////////////////// //


    // /////////////////////  Constructors  ///////////////////// //

    public Magician(String name) {
        super(name);
        this.setLifePoints(6);
        this.setStrength(15);
        this.setJob("Magicien");
        this.setOffensiveWeapon(new Spell());
        this.setDefensiveWeapon(new Charm());
    }

    // /////////////////////  Getters  ///////////////////// //



    // /////////////////////  Setters  ///////////////////// //



    // /////////////////////  Methods  ///////////////////// //



    @Override
    public void showCharacter() {
        super.showCharacter();
    }
}
