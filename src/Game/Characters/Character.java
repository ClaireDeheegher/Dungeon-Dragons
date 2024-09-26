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


    // /////////////////////  Methods  ///////////////////// //

    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", lifePoints=" + lifePoints +
                ", strength=" + strength +
                '}';
    }
    public void showCharacter(){
        System.out.println("Nom : " +name);
        System.out.println("Points de vie : " +lifePoints);
        System.out.println("Strength : " +strength);

    }
}
