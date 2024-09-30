package fr.campus.dnd.game.enemies;

public class Enemy {
    // /////////////////////  Attributes  //////////////////////// //
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;
    private int xp;

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
    public int getEnemyDamage() {
        return enemyDamage;
    }
    public int getXp() {return xp;}


    // /////////////////////  Setter  //////////////////////// //

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }
    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }
    public void setXp(int xp) {this.xp = xp;}
    // /////////////////////  Methods  //////////////////////// //


    @Override
    public String toString() {
        return "Enemy{" +
                "enemyName='" + enemyName + '\'' +
                ", enemyHealth=" + enemyHealth +
                ", enemyDamage=" + enemyDamage +
                ", xp=" + xp +
                '}';
    }
}
