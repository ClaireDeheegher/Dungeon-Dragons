package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Warrior;
import fr.campus.dnd.game.environment.Biome;

public class Wraith extends Enemy implements IsFriend{
    public Wraith() {
        this.setEnemyName("Wraith");
        this.setEnemyHealth(15);
        this.setDamage(5);
        this.setXp(100);

    }

    @Override
    public void checkIfFriendly(Character character) {
        if (character instanceof Hunter || character instanceof Warrior) {
            this.setIsFriendly(true);
        }
    }

    @Override
    public void getBonus(Biome biome) {
        switch (biome.getFieldName()){
            case "Castle":
                this.setDamage(9);
                System.out.println("Careful ! The wraith looks more ominous than usual");
                break;
        }
    }
}
