package fr.campus.dnd.game;

import fr.campus.dnd.game.characters.Magician;
import fr.campus.dnd.game.characters.Warrior;
import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.exceptions.PersonnageHorsPlateauException;
import fr.campus.dnd.game.items.Item;
import fr.campus.dnd.game.boardTile.BonusTile;
import fr.campus.dnd.game.boardTile.EmptyTile;
import fr.campus.dnd.game.boardTile.EnemyTile;
import fr.campus.dnd.game.boardTile.Tile;
import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.items.consumable.Potion;
import fr.campus.dnd.game.items.offensiveEquipment.OffensiveWeapon;
import fr.campus.dnd.game.items.offensiveEquipment.Spell;
import fr.campus.dnd.game.items.offensiveEquipment.Weapon;

public class Game {

    // /////////////////////  Attributes  ///////////////////// //

    private int[] board = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int boardTile = 0;

    // /////////////////////  Getter  ///////////////////// //

    private int[] getBoard() {
        return board;
    }
    private int getBoardTile(){
        return boardTile;
    }


    // /////////////////////  Setter  ///////////////////// //

    public void setBoard(int[] board) {
        this.board = board;
    }
    public void setBoardTile(int boardTile) {
        this.boardTile = boardTile;
    }

    // /////////////////////  Methods  ///////////////////// //

    public void levelUp (Character hero, int heroXP) {
        hero.levelUP();
        heroXP =hero.resetCharacterXP(heroXP);
        hero.resetLevelXP();
        System.out.println("Votre personnage vient de level up ! Il est désormais niveau "+hero.getLevel()+ ". Il lui faut désormais "+ hero.getLevelXP()+ " xp  monter de niveau !");
    }

   public void getItemEffect(Character hero, Item item) {
        if (item instanceof Potion) {
            hero.regenHP((Potion) item);
        }
        if (item instanceof OffensiveWeapon){
            if (item instanceof Spell && hero instanceof Magician){
                hero.switchOffensiveSpell((Spell) item);
            }
            else if (item instanceof Weapon && hero instanceof Warrior){
                hero.switchOffensiveWeapon((Weapon) item);
            }
            else {
                System.out.println("This equipment is not suitable for your class ! You throw it angrily to the ground and continue your journey !");
            }
        }
   }


    ////////////////////////////////////////////  How to know the tile you're on   ///////////////////////////////

    public Tile generateTile(int tile){

        Tile tileEffect = switch (tile) {
            case 1,5,9,13,17,21,25,29,33,37,41,45,49,53,57,61 -> new BonusTile();
            case 3,7,11,15,19,23,27,31,35,39,43,47,51,55,59,63 -> new EnemyTile();
            default -> new EmptyTile();
        };
        return tileEffect;
    }
    public void tileCheck(int boardTile, Character hero){

            Tile tile = generateTile(boardTile);
            if (tile instanceof BonusTile) {
                Item item = ((BonusTile) tile).getItem();
                System.out.println("You arrived on a bonus tile ! You open the chest and received a " + item.getName());
                getItemEffect(hero, item);
            }
            else if (tile instanceof EnemyTile) {
                Enemy enemy = ((EnemyTile) tile).generateEnemy();
                System.out.println("You arrived on a enemy tile ! You'll encounter a " +enemy.getEnemyName());
                ((EnemyTile) tile).Fight(enemy, hero);
            }
            else {
                System.out.println("You arrived on a empty room. Nothing will happen for now and you can rest...");
            }

    }



    ////////////////////////////////////////////////// Character moves //////////////////////////////////////
    public void playATurn (Character hero, int heroXP ){
        int dice1 = throwDice();
        int dice2 = throwDice();
        boardTile = getMoving(boardTile, dice1, dice2);
        System.out.println("You roll the dices. They fall on " +dice1+" and "+dice2+ " ! You go to the tile "+boardTile);
        tileCheck(boardTile, hero);
        if (heroXP >= hero.getLevelXP()){
            levelUp(hero, heroXP);
        }
    }

    /**
     * Method to throw a dice and getting a random result between 1 and 6
     * @return dice result
     */
    public int throwDice(){
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
    public void outOfBounds() throws PersonnageHorsPlateauException {
        if(boardTile>64){
            throw new PersonnageHorsPlateauException("Vous sortez du plateau !");
        }
    }

    /////////////////////////////////////////////////// Testing methods ///////////////////////////////////////////////////

    public void testTurnGame (int [] board, Character hero){
        int boardTile =0;
        int heroXP = 0;
        for (int i = 0; i < board.length; i++) {
            int dice1 = throwDice();
            int dice2 = throwDice();
            boardTile = getMoving(boardTile, dice1, dice2);
            try {
                outOfBounds();
            }
            catch(PersonnageHorsPlateauException e){
                System.out.println("Le dé est tombé sur "+ dice1 + " et "+dice2+". Vous êtes arrivé à la sortie ! Félicitations vous n'êtes pas des noobs");
                break;
            }
            System.out.println("Les dés ont fait " +dice1+" et "+dice2+ " ! Vous tombez sur la case "+boardTile);
            heroXP = heroXP+50;
            if (heroXP >= hero.getLevelXP()){
                hero.levelUP();
                heroXP =hero.resetCharacterXP(heroXP);
                hero.resetLevelXP();
                System.out.println("Votre personnage vient de level up ! Il est désormais niveau "+hero.getLevel()+ ". Il lui faut désormais "+ hero.getLevelXP()+ " xp  monter de niveau !");
                hero.showCharacter();
            }


        }
    }

}
