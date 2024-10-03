package fr.campus.dnd.game.environment;

import fr.campus.dnd.game.boardTile.Tile;
import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.Item;

import java.util.ArrayList;

public interface FieldGeneration {
    public Item generateItem();
    public Enemy generateEnemies();
    public ArrayList<Tile> generateBoard();

    void tileEvent(fr.campus.dnd.game.characters.Character hero);
}
