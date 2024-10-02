package fr.campus.dnd.game.characters;

import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.defensiveEquipment.Charm;
import fr.campus.dnd.game.items.offensiveEquipment.Spell;

public class Magician extends Character implements GetStats {

    // /////////////////////  Attributes  //////////////////////// //


    // /////////////////////  Constructors  ///////////////////// //

    public Magician(String name) {
        super(name);

        this.setJob("Magician");
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

    public void generateHp() {
        int max = 6;
        int min = 3;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 3;
        this.setLifePoints(random);

    }
    public void generateAtk(){
        int max = 15;
        int min = 8;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 8;
        this.setStrength(random);
    }

    @Override
    public int generateBonusDamage(Enemy enemy) {
        return switch (enemy.getEnemyName()) {
            case "Wraith" -> 3;
            case "Dragon" -> -2;
            default -> 0;
        };
    }
}
