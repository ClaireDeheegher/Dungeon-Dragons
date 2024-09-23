package Game.Character_settings;

public abstract class Character {

    // /////////////////////  Attributes  //////////////////////// //

    private String name = "";
    private String job= "";
    int lifePoints;
    private int strength;
    private String oWeaponType;
    private String oWeaponName;
    private int oWeaponLevel;
    private String dWeaponType;
    private String dWeaponName;
    private int dWeaponLevel;
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

        switch (job) {
            case "magicien":
                lifePoints = 6;
                strength = 15;
                oWeaponType = "Sort";
                oWeaponName = "Feu";
                oWeaponLevel = 1;
                dWeaponType = "Philtre";
                dWeaponName = "Potion de vie";
                dWeaponLevel = 1;
                break;
            case "guerrier":
                lifePoints = 10;
                strength = 10;
                oWeaponType = "Arme";
                oWeaponName = "Hache rouillée";
                oWeaponLevel = 1;
                dWeaponType = "Bouclier";
                dWeaponName = "Bouclier en bois";
                dWeaponLevel = 1;
                break;
            }
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
    public OffensiveWeapon getOffensiveWeapon(){
        return this.offensiveWeapon;
    }
    public DefensiveWeapon getDefensiveWeapon(){
        return this.defensiveWeapon;
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
    public void setOffensiveWeapon (OffensiveWeapon offensiveWeapon){
        this.offensiveWeapon = offensiveWeapon;
    }
    public void setDefensiveWeapon (DefensiveWeapon defensiveWeapon){
        this.defensiveWeapon = defensiveWeapon;
    }

    // /////////////////////  Methods  ///////////////////// //

    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", oWeaponType='" + oWeaponType + '\'' +
                ", oWeaponName='" + oWeaponName + '\'' +
                ", oWeaponLevel=" + oWeaponLevel +
                ", dWeaponType='" + dWeaponType + '\'' +
                ", dWeaponName='" + dWeaponName + '\'' +
                ", dWeaponLevel=" + dWeaponLevel +
                ", offensiveWeapon=" + offensiveWeapon +
                ", defensiveWeapon=" + defensiveWeapon +
                '}';
    }
    public void showCharacter(){
        System.out.println("Nom : " +name);

    }
}
