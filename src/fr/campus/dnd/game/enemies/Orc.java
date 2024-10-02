package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Magician;

public class Orc extends Enemy implements IsFriend{
    public Orc(){
        this.setEnemyName("Orc");
        this.setEnemyHealth(10);
        this.setEnemyDamage(6);
        this.setXp(100);

    }

    @Override
    public void checkIfFriendly(Character character) {
        if (character instanceof Hunter || character instanceof Magician) {
            this.setIsFriendly(true);
        }

    }
}
