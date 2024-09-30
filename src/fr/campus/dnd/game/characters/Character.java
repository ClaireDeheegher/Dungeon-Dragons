package fr.campus.dnd.game.characters;


import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.Item;
import fr.campus.dnd.game.items.consumable.Potion;
import fr.campus.dnd.game.items.defensiveEquipment.DefensiveWeapon;
import fr.campus.dnd.game.items.offensiveEquipment.*;

import java.util.Scanner;

public abstract class Character {

    // /////////////////////  Attributes  //////////////////////// //

    private String name = "";
    private String job= "";
    private int lifePoints;
    private int strength;
    private OffensiveWeapon offensiveWeapon;
    private DefensiveWeapon defensiveWeapon;
    private int characterXP = 0;
    private int level = 1;
    private int levelXP = 100;

    // /////////////////////  Constructors  ///////////////////// //

    Character(){
    }

    Character(String name){
        this.name = name;
    }

    public Character(String name, String job){

        this.name = name;
        this.job = job;
    }

    // /////////////////////  Getters  ///////////////////// //

    public String getName(){
        return this.name;
    }
    public String getJob(){
        return this.job;
    }
    public int getLifePoints(){
        return this.lifePoints;
    }
    public int getStrength(){
        return this.strength;
    }
    public DefensiveWeapon getDefensiveWeapon() {return defensiveWeapon;}
    public OffensiveWeapon getOffensiveWeapon() {return offensiveWeapon;}
    public int getCharacterXP() {return characterXP;}
    public int getLevel() {return level;}
    public int getLevelXP() {return levelXP;}
    // /////////////////////  Setters  ///////////////////// //


    public void setName(String name) {
        this.name = name;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setDefensiveWeapon(DefensiveWeapon defensiveWeapon) {this.defensiveWeapon = defensiveWeapon;}
    public void setOffensiveWeapon(OffensiveWeapon offensiveWeapon) {this.offensiveWeapon = offensiveWeapon;}
    public void setCharacterXP(int characterXP) {this.characterXP = characterXP;}
    public void setLevel(int level) {this.level = level;}
    public void setLevelXP(int levelXP) {this.levelXP = levelXP;}


    // /////////////////////  Methods  ///////////////////// //

    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", characterXP=" + characterXP +
                ", level=" + level +
                ", levelXP=" + levelXP +
                ", offensiveWeapon=" + offensiveWeapon +
                ", defensiveWeapon=" + defensiveWeapon +
                '}';
    }
    public void showCharacter(){
        System.out.println("Nom : " +name);
        System.out.println("Points de vie : " +lifePoints);
        System.out.println("Strength : " +strength);
        System.out.println("Character XP : " +characterXP);
        System.out.println("Level : " +level);
        System.out.println("Level XP : " +levelXP);
        System.out.println("Arme " +offensiveWeapon.getName());

    }

    public void gainXP(int xp){
        characterXP += xp;
    }

    public void levelUP (){
        lifePoints = lifePoints +2;
        strength = strength +2;
        level++;
    }
    public int resetCharacterXP(int xp){
        characterXP = xp;
        characterXP -= levelXP;
        return characterXP;
    }
    public void resetLevelXP(){
        levelXP = levelXP + (int)(levelXP*0.2);
    }

    public void switchOffensiveSpell(OffensiveWeapon item){
       if (item instanceof Fireball) {
           if (item.getDamage()>offensiveWeapon.getDamage()) {
           offensiveWeapon = new Fireball();
           strength += 7;
           System.out.println("You equip the Fireball and leave your former weapon to the ground before resuming your journey to the dungeon.");
           }
           else {
               System.out.println("You find out that this equipment is not suited for your needs. You leave it to the ground and resume your journey.");
           }
       }
       if (item instanceof Thunder){
           if (item.getDamage()>offensiveWeapon.getDamage()) {
               offensiveWeapon = new Thunder();
               strength += 2;
               System.out.println("You equip the Thunder and leave your former weapon to the ground before resuming your journey to the dungeon.");
           }
           else {
               System.out.println("You find out that this equipment is not suited for your needs. You leave it to the ground and resume your journey.");
           }
       }
    }
    public void switchOffensiveWeapon(OffensiveWeapon item){
        if (item instanceof Mace){
            if (item.getDamage()>offensiveWeapon.getDamage()) {
                offensiveWeapon = new Mace();
                strength += 3;
                System.out.println("You equip the Mace and leave your former weapon to the ground before resuming your journey to the dungeon.");
            }
            else {
                System.out.println("You find out that this equipment is not suited for your needs. You leave it to the ground and resume your journey.");
            }
        }
        if (item instanceof Sword){
            if (item.getDamage()>offensiveWeapon.getDamage()) {
                offensiveWeapon = new Sword();
                strength += 5;
                System.out.println("You equip the Sword and leave your former weapon to the ground before resuming your journey to the dungeon.");
            }
            else {
                System.out.println("You find out that this equipment is not suited for your needs. You leave it to the ground and resume your journey.");
            }
        }
    }
    public void regenHP (Potion potion){
        switch (potion.getName()){
            case "Small Potion":
                lifePoints+=2;
                System.out.println("Tou drank the small potion ! You gain 2 HP !");
                break;
            case "Big Potion":
                lifePoints+=5;
                System.out.println("Tou drank the small potion ! You gain 5 HP !");
                break;
        }
    }
    public void playerAttack (Enemy monster){
        int monsterHP = monster.getEnemyHealth();

        monsterHP -= strength;
        monster.setEnemyHealth(monsterHP);


        }
    public void monsterAttack(Enemy monster){

        int monsterAtk = monster.getEnemyDamage();
        lifePoints -= monsterAtk;

    }

}
