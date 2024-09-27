package Game.boardTile;

import Game.Characters.Character;
import Game.Enemies.Dragon;
import Game.Enemies.Enemy;
import Game.Enemies.Goblin;
import Game.Enemies.Sorcerer;
import Game.Game;

import java.util.Scanner;

public class EnemyTile extends Tile{

    // /////////////////////  Attributes  //////////////////////// //
    private Enemy monster;

    // /////////////////////  Constructor  //////////////////////// //
    public EnemyTile () {
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
        int max = 3;
        int range = max - min + 1;
        int generator =(int)(Math.random()*range)+1;
        monster = switch (generator) {
            case 1 -> new Goblin();
            case 2 -> new Sorcerer();
            case 3 -> new Dragon();
            default -> monster;
        };
        return monster;
    }

    public void Fight (Enemy monster, Character hero){
        Scanner scanner = new Scanner(System.in);
        int monsterHP = monster.getEnemyHealth();
        int monsterAtk = monster.getEnemyDamage();
        int heroHP = hero.getLifePoints();
        int heroAtk = hero.getStrength();
        while (heroHP>0){

            monsterHP -= heroAtk;

            if (monsterHP<=0){
                System.out.println("the "+monster.getEnemyName()+" is defeated ! You still have "+heroHP+" life points left." );
                break;
            }

            System.out.println("You inflicted "+heroAtk+" damage to your opponent ! It still has "+monsterHP+" life points left.");
            heroHP -= monsterAtk;

            if (heroHP<=0){
                System.out.println("The "+monster.getEnemyName()+" has defeated you..... Game over");
                System.exit(0);
            }
            System.out.println("The "+monster.getEnemyName()+ " has inflicted "+monsterAtk+" damage ! You still have "+heroHP+" life points left.");
        }
    }

}
