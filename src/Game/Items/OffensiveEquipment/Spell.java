package Game.Items.OffensiveEquipment;


public class Spell extends OffensiveWeapon{

    // /////////////////////  Attributes  //////////////////////// //


    private int spellLevel;
    private int spellDamage;

    // /////////////////////  Constructors  ///////////////////// //

    public Spell(){
        this.setName("Spell");
    }



    // /////////////////////  Getters  ///////////////////// //

    public int getSpellLevel() {
        return spellLevel;
    }
    public int getSpellDamage() {return spellDamage;}



    // /////////////////////  Setters  ///////////////////// //


    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }
    public void setSpellDamage(int spellDamage) {this.spellDamage = spellDamage;}

    // /////////////////////  Methods  ///////////////////// //

    @Override
    public String toString() {
        return "Spell{" +
                ", spellLevel=" + spellLevel +
                ", spellDamage=" + spellDamage +
                '}';
    }
}
