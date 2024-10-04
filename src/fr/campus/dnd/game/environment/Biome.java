package fr.campus.dnd.game.environment;

import fr.campus.dnd.game.boardTile.BonusTile;
import fr.campus.dnd.game.boardTile.EmptyTile;
import fr.campus.dnd.game.boardTile.EnemyTile;
import fr.campus.dnd.game.boardTile.Tile;
import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.items.Item;
import fr.campus.dnd.game.characters.Character;

import java.util.ArrayList;
import java.util.Collections;

public class Biome implements FieldGeneration{
    // /////////////////////  Attributes  //////////////////////// //

    private ArrayList<Tile> board;
    private String fieldName;

    // /////////////////////  Constructors  ///////////////////// //

    public Biome() {}



    // /////////////////////  Getters/Setters  ///////////////////// //
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public ArrayList<Tile> getBoard() {
        return board;
    }
    public void setBoard(ArrayList<Tile> board) {
        this.board = board;
    }


    // /////////////////////  Methods  ///////////////////// //

    @Override
    public ArrayList<Tile> generateBoard() {
        board = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            board.add(new EnemyTile());
        }
        for (int i = 0; i < 24; i++) {
            board.add(new BonusTile());
        }
        for (int i = 0; i < 18; i++) {
            board.add(new EmptyTile());
        }
        Collections.shuffle(board);
        for (int i = 0; i < 7; i++) {
            board.add(new EmptyTile());
        }
        return board;
    }
    @Override
    public Enemy generateEnemies() {
        return null;
    }

    @Override
    public Item generateItem() {
        return null;
    }

    @Override
    public void tileEvent(Character hero) {
        BonusTile tile = new BonusTile();
        int dice;
        int max = 20;
        int min = 1;
        int range = max - min+1;
        dice = (int) (Math.random() * range) + min;
        switch (dice) {
            case 1:
                System.out.println("You happen to walk on a spiked floor. It hurts like hell ! You lose 2hp.");
                hero.setLifePoints(hero.getLifePoints() - 2);
                if (hero.getLifePoints()<=0){
                    System.out.println("Game over ! You died from a trap you noob");
                    System.exit(0);
                }
                break;
            case 6 :
                System.out.println("You saw something shiny ! You approach carefully and discover a chest !");
                Item chest = tile.getItem();
                tile.getItemEffect(hero, chest);
                break;
            default :
                break;

        }
    }
}
