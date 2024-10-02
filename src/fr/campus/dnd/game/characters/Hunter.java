package fr.campus.dnd.game.characters;

import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.offensiveEquipment.Bow;

public class Hunter extends Character implements GetStats{
    // /////////////////////  Attributes  //////////////////////// //



    // /////////////////////  Constructors  ///////////////////// //
    public Hunter(String name) {
        this.setJob("Hunter");
        this.setOffensiveWeapon(new Bow());

    }
    // /////////////////////  Getters  ///////////////////// //

    // /////////////////////  Setters  ///////////////////// //

    // /////////////////////  Methods  ///////////////////// //
    @Override
    public void generateAtk() {
        int max = 15;
        int min = 5;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 5;
        this.setStrength(random);
    }
    public void generateHp(){
        int max = 8;
        int min = 5;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 5;
        this.setLifePoints(random);
    }
    @Override
    public int generateBonusDamage(Enemy monster){
        return switch (monster.getEnemyName()) {
            case "Dragon" -> 2;
            case "Orc" -> -1;
            default -> 0;
        };
    }

}
