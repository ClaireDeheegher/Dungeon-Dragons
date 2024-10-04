package fr.campus.dnd.game;
import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Magician;
import fr.campus.dnd.game.characters.Warrior;
import fr.campus.dnd.game.db.ConnectionDB;
import fr.campus.dnd.game.environment.*;

import java.util.Scanner;

public class Menu {
    ConnectionDB db = new ConnectionDB();
    /*
    Trouver comment stopper le programme
     */

    /**
     * méthode StartMenu permettant de lancer le jeu.
     */
    public void startMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Dungeon and dragons!");
        System.out.println("Would you like to play again? (Y/N)");
        String answer = input.nextLine();
        switch(answer) {
            case "Y":
                System.out.println("Let's create your character !");
                break;
            case "N":
                System.out.println("Goodbye ! Have a nice day !");
                System.exit(0);
                break;
        }
    }

    /**
     * Méthode createCharacter permettant de créer un personnage.
     * Utilise les input console pour réaliser les choix de création de personnage.
     * Instanciation des classes enfant Magician et Warrior en fonction des inputs.
     */
    public Character createCharacter(){
        Scanner characterInput = new Scanner(System.in);

        System.out.println("Write your name hero.");
        String name = characterInput.nextLine();

        Character character;
        System.out.println("There's 3 jobs available for you : warrior(1), magician(2) or hunter(3). Put the corresponding number to get your job");
        String job = characterInput.nextLine();
            switch (job){
                case "1":
                    character = new Warrior(name);
                    ((Warrior) character).generateHp();
                    ((Warrior)character).generateAtk();
                    break;
                case "2":
                    character = new Magician(name);
                    ((Magician) character).generateAtk();
                    ((Magician)character).generateHp();
                    break;
                case "3":
                    character = new Hunter(name);
                    ((Hunter) character).generateAtk();
                    ((Hunter)character).generateHp();
                    break;
                default:
                    System.out.println("Sorry, that is not a valid option!");
                    character =createCharacter();
            }

        return character;
    }
    public void continueMenu(Character character) {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to go to the next turn ? You can choose yes to continue, no to stop and character to see your stats ! ");
        String answer = input.nextLine();
        switch (answer){
            case "yes" :
                break;
            case "no" :
                db.saveData( character);
                db.checkSavedData();
                System.out.println("Goodbye ! Have a nice day !");
                System.exit(0);
                break;
            case "character":
                character.showCharacter();
                break;
        }

    }
    public Biome generateBiome(){
        Biome biome;
        int min = 1;
        int max = 5;
        int range = max - min+1;
        int random = (int) (Math.random()*range+min);
        switch (random){
            case 1 :
                biome = new Castle();
                System.out.println("You set foot in the entrance of a sinister Castle. You sense a presence behind you which chill your spine. You look behind you but see nothing. The door closes suddenly. You'll have to go to then end and beat the boss, or die trying....");
                break;
            case 2 :
                biome = new Cave();
                System.out.println("You set foot into a damp Cave. You sense a rumble which seems to come from the depths. You wonder if you should come back later, but the greed seems to get the better of you. You continue going deeper into the darkness, the light of your torch flickering against the wall... ");
                break;
            case 3 :
                biome = new Forest();
                System.out.println("You set foot into a lush forrest. The massive trees offers you a nice shade from the harsh rays of the sun. You hope you won't get lost and find the legendary fountain of youth....  ");
                break;
            case 4 :
                biome = new SnowMountain();
                System.out.println("You arrive at the foot of a huge snowy mountain. You shiver in your clothes, hoping a blizzard won't strike in...");
                break;
            default :
                biome = new Volcano();
                System.out.println("You arrive at the foot of a huge volcano, carefully walking in order not to step on molten lava. You're already sweating from the heat and hope you won't encounter a nasty dragon during your journey");

        }
        return biome;
    }
}


