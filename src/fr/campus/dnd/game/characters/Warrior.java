package fr.campus.dnd.game.characters;

import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.defensiveEquipment.Shield;
import fr.campus.dnd.game.items.offensiveEquipment.Weapon;

public class Warrior extends Character implements GetStats {

    // /////////////////////  Attributes  //////////////////////// //



    // /////////////////////  Constructors  ///////////////////// //

    public Warrior(String name) {
        super(name);
        this.setJob("Warrior");
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
    public void generateHp() {
        int max = 10;
        int min = 5;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 5;
        this.setLifePoints(random);

    }

    public void generateAtk() {
        int max = 10;
        int min = 5;
        int range = max - min + 1;
        int random = (int) (Math.random() * range) + 5;
        this.setStrength(random);
    }

    @Override
    public int generateBonusDamage(Enemy enemy) {
        return switch (enemy.getEnemyName()) {
            case "Dragon" -> -2;
            case "Goblin" -> 3;
            default -> 0;
        };
    }
}
