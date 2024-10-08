package fr.campus.dnd.game.enemies;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.environment.Biome;

public class Enemy implements IsFriend, BiomeBonus{
    // /////////////////////  Attributes  //////////////////////// //
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;
    private String biome;
    private int xp;
    private boolean isFriendly = false;

    // /////////////////////  Constructor  //////////////////////// //

    public Enemy(){}

    public Enemy(String enemyName){
        this.enemyName = enemyName;
    }

    // /////////////////////  Getter  //////////////////////// //

    public String getEnemyName() {
        return enemyName;
    }
    public int getEnemyHealth() {
        return enemyHealth;
    }
    public int getDamage() {
        return enemyDamage;
    }
    public String getBiome() {return biome;}
    public int getXp() {return xp;}

    public boolean getIsFriendly() {return isFriendly;}


    // /////////////////////  Setter  //////////////////////// //

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }
    public void setDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }
    public void setBiome(String biome) {this.biome = biome;}
    public void setXp(int xp) {this.xp = xp;}

    public void setIsFriendly(boolean isFriendly) {this.isFriendly = isFriendly;}

    // /////////////////////  Methods  //////////////////////// //


    @Override
    public String toString() {
        return "Enemy{" +
                "enemyName='" + enemyName + '\'' +
                ", enemyHealth=" + enemyHealth +
                ", enemyDamage=" + enemyDamage +
                ", xp=" + xp +

                ", isFriendly=" + isFriendly +
                '}';
    }

    @Override
    public void checkIfFriendly(Character character) {

    }

    @Override
    public void getBonus(Biome biome) {

    }
}
