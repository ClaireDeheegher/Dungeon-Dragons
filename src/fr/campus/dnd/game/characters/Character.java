package fr.campus.dnd.game.characters;


import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.consumable.Potion;
import fr.campus.dnd.game.items.defensiveEquipment.DefensiveWeapon;
import fr.campus.dnd.game.items.offensiveEquipment.*;

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
    public String getDefensiveWeapon() {return defensiveWeapon.toString();}
    public String getOffensiveWeapon() {return offensiveWeapon.toString();}
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
        upStrength();
        upHp();
        level++;
    }
    public int resetCharacterXP(){
        characterXP -= levelXP;
        return characterXP;
    }
    public void resetLevelXP(){
        levelXP = levelXP + (int)(levelXP*0.2);
    }
    public void upStrength(){
        int max = 2;
        int min = 0;
        int range = max - min;
        int random = (int) (Math.random() * range);
        strength = strength +random;
    }
    public void upHp(){
        int max = 2;
        int min = 0;
        int range = max - min;
        int random = (int) (Math.random() * range);
        lifePoints = lifePoints +random;
    }

    public void switchOffensiveWeapon(OffensiveWeapon item){
        if (item.getDamage()>offensiveWeapon.getDamage()){
            strength += item.getDamage();
            offensiveWeapon =item;
            System.out.println("You equip the "+offensiveWeapon.getName()+ " and leave your former weapon to the ground before resuming your journey to the dungeon.");
        }
        else {
            System.out.println("You find out that this equipment is not suited for your needs. You leave it to the ground and resume your journey.");
        }
    }

    public void regenHP (Potion potion){
        lifePoints+= potion.getRegenHP();
        System.out.println("Tou drank the "+potion.getName()+" ! You gain "+potion.getRegenHP()+" HP !");
    }

    public int calculateDamages(int bonusDamage){
        int max =6;
        int min = 1;
        int range = max - min+1;
        int random = (int) (Math.random() * range)+1;
        return switch (random) {
            case 1 -> 0;
            case 6 -> bonusDamage + strength + (int) ((bonusDamage + strength) * 0.5);
            default -> bonusDamage + strength;
        };
    }
    public void monsterAttack(Enemy monster){

        int monsterAtk = monster.getDamage();
        lifePoints -= monsterAtk;

    }
    public int generateBonusDamage(Enemy enemy){
        return 0 ;
    }

}
