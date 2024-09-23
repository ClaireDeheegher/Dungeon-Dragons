package Game.Character_settings;

public class Spell extends OffensiveWeapon{

    // /////////////////////  Attributes  //////////////////////// //

    private String spellName;
    private int spellLevel;

    // /////////////////////  Constructors  ///////////////////// //

    public Spell(){
    }

    public Spell(String name,  int level){
        this.spellName = name;
        this.spellLevel = level;
    }

    // /////////////////////  Getters  ///////////////////// //

    public int getSpellLevel() {
        return spellLevel;
    }
    public String getSpellName() {
        return spellName;
    }


    // /////////////////////  Setters  ///////////////////// //

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }
    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Spell{" +
                "spellName='" + spellName + '\'' +
                ", spellLevel=" + spellLevel +
                '}';
    }
}
