package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.environment.Biome;

public class Dragon extends Enemy implements IsFriend, BiomeBonus {
    // /////////////////////  Attributes  //////////////////////// //

    // /////////////////////  Constructors  //////////////////////// //

    public Dragon() {
        this.setEnemyName("Dragon");
        this.setEnemyHealth(15);
        this.setEnemyDamage(4);
        this.setXp(150);

    }

    // /////////////////////  Getter/Setter  //////////////////////// //


    // /////////////////////  Methods  //////////////////////// //


    @Override
    public void checkIfFriendly(Character character) {

    }

    @Override
    public void getBonus(Biome biome) {
        switch (biome.getFieldName()){
            case "Volcano":
                this.setEnemyDamage(19);
                System.out.println("Careful ! The dragon gets more power from the lava in the volcano !");
                break;
            case "SnowMountain" :
                this.setEnemyDamage(11);
                System.out.println("You don't know why the hell is a dragon here, but it's looking weaker than usual.");
                break;
        }
    }
}
