package fr.campus.dnd.game.enemies;

public class Dragon extends Enemy implements IsFriend {
    // /////////////////////  Attributes  //////////////////////// //

    // /////////////////////  Constructors  //////////////////////// //

    public Dragon() {
        this.setEnemyName("Dragon");
        this.setEnemyHealth(15);
        this.setEnemyDamage(4);
        this.setXp(150);
        this.getFriendlyJobs().add("Beast Tamer");
    }

    // /////////////////////  Getter  //////////////////////// //

    // /////////////////////  Setter  //////////////////////// //

    // /////////////////////  Methods  //////////////////////// //





}
