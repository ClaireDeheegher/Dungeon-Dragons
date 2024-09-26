package Game.Enemies;

public class Enemy {
    // /////////////////////  Attributes  //////////////////////// //
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;

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
    // /////////////////////  Methods  //////////////////////// //


    @Override
    public String toString() {
        return "Enemy{" +
                "enemyName='" + enemyName + '\'' +
                ", enemyHealth=" + enemyHealth +
                ", enemyDamage=" + enemyDamage +
                '}';
    }
}
