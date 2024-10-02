package fr.campus.dnd.game.characters;

import fr.campus.dnd.game.enemies.Enemy;

public interface GetStats {
    public void generateHp();
    public void generateAtk();
    public int generateBonusDamage(Enemy enemy);
}
