package fr.campus.dnd.game;

import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Magician;
import fr.campus.dnd.game.characters.Warrior;
import fr.campus.dnd.game.enemies.Dragon;
import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.enemies.Goblin;
import fr.campus.dnd.game.enemies.Sorcerer;
import fr.campus.dnd.game.exceptions.PersonnageHorsPlateauException;
import fr.campus.dnd.game.items.Item;
import fr.campus.dnd.game.boardTile.BonusTile;
import fr.campus.dnd.game.boardTile.EmptyTile;
import fr.campus.dnd.game.boardTile.EnemyTile;
import fr.campus.dnd.game.boardTile.Tile;
import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.items.consumable.Potion;
import fr.campus.dnd.game.items.offensiveEquipment.Bow;
import fr.campus.dnd.game.items.offensiveEquipment.OffensiveWeapon;
import fr.campus.dnd.game.items.offensiveEquipment.Spell;
import fr.campus.dnd.game.items.offensiveEquipment.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // /////////////////////  Attributes  ///////////////////// //

    private ArrayList<Tile> board;
    private int boardTile = 0;

    // /////////////////////  Getter  ///////////////////// //

    private ArrayList<Tile> getBoard() {
        return board;
    }
    private int getBoardTile(){
        return boardTile;
    }

    // /////////////////////  Setter  ///////////////////// //

    public void setBoard(ArrayList<Tile> board) {
        this.board = board;
    }
    public void setBoardTile(int boardTile) {
        this.boardTile = boardTile;
    }

    // /////////////////////  Methods  ///////////////////// //



    public void levelUp (Character hero) {
        hero.levelUP();
        hero.resetCharacterXP();
        hero.resetLevelXP();
        System.out.println("Congrats ! You level up ! Your level is now "+hero.getLevel()+ ". You need "+ hero.getLevelXP()+ " xp  to level up again !");
    }

   public void getItemEffect(Character hero, Item item) {
        if (item instanceof Potion) {
            hero.regenHP((Potion) item);
        }
        if (item instanceof OffensiveWeapon){
            if (item instanceof Spell && hero instanceof Magician){
                hero.switchOffensiveWeapon((Spell) item);
            }
            else if (item instanceof Weapon && hero instanceof Warrior){
                hero.switchOffensiveWeapon((Weapon) item);
            }
            else if (item instanceof Bow && hero instanceof Hunter){
                hero.switchOffensiveWeapon((Bow) item);
            }
            else {
                System.out.println("This equipment is not suitable for your class ! You throw it angrily to the ground and continue your journey !");
            }
        }
   }
    public void getEmptyTileEvent(int dice, Character hero) {
        BonusTile tile = new BonusTile();
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
                getItemEffect(hero, chest);
                break;
            default :
                break;

        }
    }
    public void fightMonster(Character hero, Enemy monster){

        String choice ="";
        Scanner input = new Scanner(System.in);
        int bonusDamage = 0;
        int damages=0;
        int monsterLife = monster.getEnemyHealth();

        while (hero.getLifePoints()>0 && monsterLife>0 && !choice.equals("runaway")) {
            System.out.println("Do you want to fight ? or runaway?");
            choice = input.nextLine();
            switch (choice) {
                case "runaway":
                    flightFromFight();
                    break;
                case "fight" :
                    bonusDamage = hero.generateBonusDamage(monster);
                    damages = hero.calculateDamages(bonusDamage);
                    monsterLife = dealDamages(monsterLife,damages);

                    if (monsterLife<=0){
                        hero.gainXP(monster.getXp());

                        System.out.println("You inflicted "+damages+" damages. The "+monster.getEnemyName()+" is defeated ! You gained "+monster.getXp()+" xp !" );
                        board.set(boardTile, new EmptyTile(boardTile));
                        break;
                    }
                    else if(damages ==0){
                        System.out.println("You tripped and failed to touch the "+monster.getEnemyName()+" ! You inflicted no damages...");
                    }
                    else {
                        System.out.println("You inflicted "+damages+" damage to your opponent ! It still has "+monsterLife+" life points left.");
                    }

                    hero.monsterAttack(monster);
                    if (hero.getLifePoints()<=0){
                        System.out.println("The "+monster.getEnemyName()+" has defeated you..... Game over");
                        System.exit(0);
                    }
                    System.out.println("The "+monster.getEnemyName()+ " has inflicted "+monster.getEnemyDamage()+" damage ! You still have "+hero.getLifePoints()+" life points left.");
                    break;
            }

        }

    }
    public int dealDamages (int health, int damages){
        return health - damages;
    }
    ////////////////////////////////////////////// Initialize the board ///////////////////////////

    public void boardSetup() {
    board = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            switch (i) {
                case 1, 5, 9, 13, 17, 21, 25, 29, 33, 37, 41, 45, 49, 53, 57, 61 -> board.add(new BonusTile(i));
                case 3, 7, 11, 15, 19, 23, 27, 31, 35, 39, 43, 47, 51, 55, 59, 63 -> board.add(new EnemyTile(i));
                default -> board.add(new EmptyTile(i));
            }

        }
    }

        ////////////////////////////////////////////  How to know the tile you're on   ///////////////////////////////


        public void tileCheck (int boardTile, Character hero){

            Tile tile = board.get(boardTile);

            if (tile instanceof BonusTile) {
                Item item = ((BonusTile) tile).getItem();
                System.out.println("You arrived on a bonus tile ! You open the chest and received a " + item.getName());
                getItemEffect(hero, item);
                hero.gainXP(40);
                board.set(boardTile, new EmptyTile(boardTile));

            } else if (tile instanceof EnemyTile) {
                Enemy enemy = ((EnemyTile) tile).generateEnemy();
                enemy.checkIfFriendly(hero);
                System.out.println("You arrived on a enemy tile ! You'll encounter a " + enemy.getEnemyName());

                if (enemy.getIsFriendly()) {
                    System.out.println("The "+enemy.getEnemyName()+" isn't interested in you. It goes away and you gain nothing to brag about.");
                    board.set(boardTile, new EmptyTile(boardTile));
                }
                else {
                    fightMonster(hero, enemy);
                }

            } else {
                System.out.println("You arrived on a empty room. Nothing will happen for now and you can rest...");
                hero.gainXP(25);
                int dice = throwDice();
                getEmptyTileEvent(dice, hero);

            }

        }


        ////////////////////////////////////////////////// Character moves //////////////////////////////////////


        public void playATurn (Character hero){
            int dice = throwDice();
            boardTile = getMoving(boardTile, dice);
            try {
                outOfBounds();
            } catch (PersonnageHorsPlateauException e) {
                System.out.println("You arrived at the end of the dungeon ! Congrats you're not a noob :)");
                System.exit(0);
            }

            System.out.println("You roll the dices. They fall on " + dice +  " ! You go to the tile " + boardTile);
            tileCheck(boardTile, hero);
            if (hero.getCharacterXP() >= hero.getLevelXP()) {
                levelUp(hero);
            }
        }

        /**
         * Method to throw a dice and getting a random result between 1 and 6
         * @return dice result
         */
        public int throwDice () {
            int max = 6;
            int min = 1;
            int range = max - min + 1;
            int dice = (int) (Math.random() * range) + 1;
            return dice;
        }

        /**
         * Méthode allowing character move
         * Call @throwDice()
         * @param caseBoard
         * @return character new tile
         */
        public int getMoving ( int caseBoard, int dice){
            return caseBoard + dice;
        }

        /**
         * Method to check if the character will get OOB upon moving
         * @throws PersonnageHorsPlateauException
         */
        public void outOfBounds () throws PersonnageHorsPlateauException {
            if (boardTile >= 64) {
                throw new PersonnageHorsPlateauException("Vous sortez du plateau !");
            }
        }

        public void flightFromFight () {
            int max = 6;
            int min = 1;
            int range = max - min + 1;
            int flight = (int) (Math.random() * range) + 1;
            boardTile -= flight;
        }
        /////////////////////////////////////////////////// Testing methods ///////////////////////////////////////////////////

        public void testTurnGame ( int[] board, Character hero){
            int boardTile = 0;
            int heroXP = 0;
            for (int i = 0; i < board.length; i++) {
                int dice1 = throwDice();
                int dice2 = throwDice();
                boardTile = getMoving(boardTile, dice1);
                try {
                    outOfBounds();
                } catch (PersonnageHorsPlateauException e) {
                    System.out.println("Le dé est tombé sur " + dice1 +  ". Vous êtes arrivé à la sortie ! Félicitations vous n'êtes pas des noobs");
                    break;
                }
                System.out.println("Les dés ont fait " + dice1 +  " ! Vous tombez sur la case " + boardTile);
                heroXP = heroXP + 50;
                if (heroXP >= hero.getLevelXP()) {
                    hero.levelUP();
                    heroXP = hero.resetCharacterXP();
                    hero.resetLevelXP();
                    System.out.println("Votre personnage vient de level up ! Il est désormais niveau " + hero.getLevel() + ". Il lui faut désormais " + hero.getLevelXP() + " xp  monter de niveau !");
                    hero.showCharacter();
                }
            }
        }

        public void testCollections () {
             boardSetup();
            System.out.println(board);
        }


        @Override
        public String toString () {
            return "Game{" +
                    "board=" + board +
                    ", boardTile=" + boardTile +
                    '}';
        }
    }
