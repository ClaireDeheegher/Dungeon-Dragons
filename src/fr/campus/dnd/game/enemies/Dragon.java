package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;

public class Dragon extends Enemy implements IsFriend {
    // /////////////////////  Attributes  //////////////////////// //

    // /////////////////////  Constructors  //////////////////////// //

    public Dragon() {
        this.setEnemyName("Dragon");
        this.setEnemyHealth(15);
        this.setEnemyDamage(4);
        this.setXp(150);

    }

    // /////////////////////  Getter  //////////////////////// //

    // /////////////////////  Setter  //////////////////////// //

    // /////////////////////  Methods  //////////////////////// //


    @Override
    public void checkIfFriendly(Character character) {

    }
}
