package fr.campus.dnd.game;

import fr.campus.dnd.game.enemies.Enemy;
import fr.campus.dnd.game.enemies.boss.*;
import fr.campus.dnd.game.environment.Biome;
import fr.campus.dnd.game.exceptions.PersonnageHorsPlateauException;
import fr.campus.dnd.game.items.Item;
import fr.campus.dnd.game.boardTile.BonusTile;
import fr.campus.dnd.game.boardTile.EmptyTile;
import fr.campus.dnd.game.boardTile.EnemyTile;
import fr.campus.dnd.game.boardTile.Tile;
import fr.campus.dnd.game.characters.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // /////////////////////  Attributes  ///////////////////// //


    private int boardTile = 0;

    // /////////////////////  Getter  ///////////////////// //


    private int getBoardTile(){
        return boardTile;
    }

    // /////////////////////  Setter  ///////////////////// //

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


    public void fightMonster(Character hero, Enemy monster, ArrayList<Tile> board){

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
                    System.out.println("The "+monster.getEnemyName()+ " has inflicted "+monster.getDamage()+" damage ! You still have "+hero.getLifePoints()+" life points left.");
                    break;
            }

        }

    }
    public int dealDamages (int health, int damages){
        return health - damages;
    }


    public void bossFight(Character hero, Biome biome){
        int bonusDamage = 0;
        int damages=0;
        Boss boss = generateBoss(biome);
        int bossHP = boss.getHealth();
        while (hero.getLifePoints()>0 && bossHP>0) {
            damages = hero.calculateDamages(bonusDamage);
            bossHP = dealDamages(bossHP,damages);
            if (bossHP<=0){
                System.out.println("Congrats you succeeded in beating the game");
                System.exit(0);
            }
            else if(damages ==0){
                System.out.println("You tripped and failed to touch the "+boss.getName()+" ! You inflicted no damages...");
            }
            else {
                System.out.println("You inflicted "+damages+" damage to your opponent ! It still has "+bossHP+" life points left.");
            }

            hero.monsterAttack(boss);
            if (hero.getLifePoints()<=0){
                System.out.println("The "+boss.getEnemyName()+" has defeated you..... Game over");
                System.exit(0);
            }
            System.out.println("The "+boss.getName()+ " has inflicted "+boss.getDamage()+" damage ! You still have "+hero.getLifePoints()+" life points left.");

        }

        
    }
    public Boss generateBoss (Biome biome){
        Boss boss =new Boss();
        switch (biome.getClass().getSimpleName()) {
            case "Castle" ->boss= new LichKing();
            case "Cave" -> boss=new Kraken();
            case "Forest" -> boss=new Groot();
            case "SnowMountain" -> boss=new Fenrir();
            case "Volcano" -> boss=new Phoenix();
        }
        return boss;
    }
        ////////////////////////////////////////////  How to know the tile you're on   ///////////////////////////////


        public void tileCheck (int boardTile, Character hero, ArrayList<Tile> board, Biome biome){

            Tile tile = board.get(boardTile);

            if (tile instanceof BonusTile) {
                Item item = ((BonusTile) tile).getItem();
                System.out.println("You arrived on a bonus tile ! You open the chest and received a " + item.getName());
                ((BonusTile) tile).getItemEffect(hero, item);
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
                    fightMonster(hero, enemy, board);
                }

            } else {
                System.out.println("You arrived on a empty room. Nothing will happen for now and you can rest...");
                hero.gainXP(25);
                int dice = throwDice();
                biome.tileEvent(hero);

            }

        }


        ////////////////////////////////////////////////// Character moves //////////////////////////////////////


        public void playATurn (Character hero, ArrayList<Tile> board, Biome biome){
            int dice = throwDice();
            boardTile = getMoving(boardTile, dice);
            if (boardTile>=64){
                bossFight(hero,biome);
            }
            System.out.println("You roll the dices. They fall on " + dice +  " ! You go to the tile " + boardTile);
            tileCheck(boardTile, hero, board, biome);
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




        @Override
        public String toString () {
            return "Game{" +
                    ", boardTile=" + boardTile +
                    '}';
        }
    }
