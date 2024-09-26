package Game;

import Game.Characters.Magician;
import Game.Enemies.Enemy;
import Game.Exceptions.PersonnageHorsPlateauException;
import Game.Items.Item;
import Game.boardTile.BonusTile;
import Game.boardTile.EmptyTile;
import Game.boardTile.EnemyTile;
import Game.boardTile.Tile;

public class Game {

    // /////////////////////  Attributes  ///////////////////// //

    private int[] board = {1, 2, 3, 4, 5};

    // /////////////////////  Getter  ///////////////////// //

    public int[] getBoard() {
        return board;
    }

    // /////////////////////  Setter  ///////////////////// //

    public void setBoard(int[] board) {
        this.board = board;
    }

    // /////////////////////  Methods  ///////////////////// //


    ////////////////////////////////////////////  Instancing the game  ///////////////////////////////
    /**
     * Method to play the game
     */
    public Tile checkTile(int tile){
        Tile tileEffect = switch (tile) {
            case 2 -> new BonusTile();
            case 4 -> new EnemyTile();
            default -> new EmptyTile();
        };
        return tileEffect;
    }
    public void test(int []board){
        Magician hero = new Magician("Claire");
        for (int j : board) {
            Tile tile = checkTile(j);
            if (tile instanceof BonusTile) {
                Item item = ((BonusTile) tile).getItem();
                System.out.println("You arrived on a bonus tile ! You open the chest and received a " + item.getName());
            }
            else if (tile instanceof EnemyTile) {
                Enemy enemy = ((EnemyTile) tile).generateEnemy();
                System.out.println("You arrived on a enemy tile ! You'll encounter a " +enemy.getEnemyName());
                ((EnemyTile) tile).Fight(enemy, hero);
            }
            else {
                System.out.println("You arrived on a empty room. Nothing will happen for now and you can rest...");
            }
            j++;
        }
    }


    public void startGame (int [] board){
        int boardTile =0;
        for (int i = 0; i < board.length; i++) {
            int dice1 = trowDice();
            int dice2 = trowDice();
            boardTile = getMoving(boardTile, dice1, dice2);
            try {
                outOfBounds(boardTile);
            }
            catch(PersonnageHorsPlateauException e){
                System.out.println("Le dé est tombé sur "+ dice1 + " et "+dice2+". Vous êtes arrivé à la sortie ! Félicitations vous n'êtes pas des noobs");
                break;
            }
            System.out.println("Les dés ont fait " +dice1+" et "+dice2+ " ! Vous tombez sur la case "+boardTile);
        }
    }

    ////////////////////////////////////////////////// Character moves //////////////////////////////////////
    /**
     * Method to throw a dice and getting a random result between 1 and 6
     * @return dice result
     */
    public int trowDice(){
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int dice = (int)(Math.random()*range)+1;
        return dice;
    }

    /**
     * Méthode allowing character move
     * Call @throwDice()
     * @param caseBoard
     * @return character new tile
     */
    public int getMoving (int caseBoard, int dice1, int dice2){
        return caseBoard + dice1+dice2;
    }

    /**
     * Method to check if the character will get OOB upon moving
     * @param i
     * @throws PersonnageHorsPlateauException
     */
    public void outOfBounds(int i) throws PersonnageHorsPlateauException {
        if(i>64){
            throw new PersonnageHorsPlateauException("Vous sortez du plateau !");
        }
    }

}
