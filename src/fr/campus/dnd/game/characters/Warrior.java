package fr.campus.dnd.game.characters;

import fr.campus.dnd.game.items.defensiveEquipment.Shield;
import fr.campus.dnd.game.items.offensiveEquipment.Weapon;

public class Warrior extends Character {

    // /////////////////////  Attributes  //////////////////////// //



    // /////////////////////  Constructors  ///////////////////// //

    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setJob("Guerrier");
        this.setLifePoints(10);
        this.setOffensiveWeapon(new Weapon());
        this.setDefensiveWeapon(new Shield());
    }

    // /////////////////////  Getters  ///////////////////// //

    // /////////////////////  Setters  ///////////////////// //

    // /////////////////////  Methods  ///////////////////// //


    @Override
    public void showCharacter() {
        super.showCharacter();
    }
}
