package fr.campus.dnd.game.boardTile;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.enemies.*;

import java.util.Scanner;

public class EnemyTile extends Tile{

    // /////////////////////  Attributes  //////////////////////// //
    private Enemy monster;

    // /////////////////////  Constructor  //////////////////////// //
    public EnemyTile () {

    }
    public EnemyTile (int x) {
        super(x);
    }

    // /////////////////////  Getter  //////////////////////// //

    public Enemy getMonster() {
        return monster;
    }


    // /////////////////////  Setter  //////////////////////// //

    public void setMonster(Enemy monster) {
        this.monster = monster;
    }

    // /////////////////////  Methods  //////////////////////// //

    public Enemy generateEnemy(){
        Enemy monster = new Enemy();
        int min = 1;
        int max = 5;
        int range = max - min + 1;
        int generator =(int)(Math.random()*range)+1;
        monster = switch (generator) {
            case 1 -> new Goblin();
            case 2 -> new Sorcerer();
            case 3 -> new Dragon();
            case 4 -> new Orc();
            case 5 -> new Wraith();
            default -> monster;
        };
        return monster;
    }



}
