package Game.Characters;


import Game.Items.DefensiveEquipment.DefensiveWeapon;
import Game.Items.OffensiveEquipment.OffensiveWeapon;

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
                '}';
    }
    public void showCharacter(){
        System.out.println("Nom : " +name);
        System.out.println("Points de vie : " +lifePoints);
        System.out.println("Strength : " +strength);
        System.out.println("Character XP : " +characterXP);
        System.out.println("Level : " +level);
        System.out.println("Level XP : " +levelXP);

    }

    public int levelUP (){
       level++;
       return level;
    }
    public int resetCharacterXP(int xp){
        characterXP = xp;
        characterXP -= levelXP;
        return characterXP;
    }
    public int resetLevelXP(){
        levelXP = levelXP + (int)(levelXP*0.2);
        return levelXP;
    }

}
