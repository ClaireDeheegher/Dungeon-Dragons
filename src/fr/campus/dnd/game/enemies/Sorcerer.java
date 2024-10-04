package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;

public class Sorcerer extends Enemy implements IsFriend{
    // /////////////////////  Attributes  //////////////////////// //

    // /////////////////////  Constructor  //////////////////////// //

    public Sorcerer() {
        this.setEnemyName("Sorcerer");
        this.setEnemyHealth(9);
        this.setDamage(2);
        this.setXp(85);
    }


    // /////////////////////  Getter  //////////////////////// //

    // /////////////////////  Setter  //////////////////////// //

    // /////////////////////  Methods  //////////////////////// //

    @Override
    public void checkIfFriendly(Character character) {

    }
}
