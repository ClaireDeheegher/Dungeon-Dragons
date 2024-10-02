package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Warrior;

public class Wraith extends Enemy implements IsFriend{
    public Wraith() {
        this.setEnemyName("Wraith");
        this.setEnemyHealth(15);
        this.setEnemyDamage(5);
        this.setXp(100);

    }

    @Override
    public void checkIfFriendly(Character character) {
        if (character instanceof Hunter || character instanceof Warrior) {
            this.setIsFriendly(true);
        }
    }
}
