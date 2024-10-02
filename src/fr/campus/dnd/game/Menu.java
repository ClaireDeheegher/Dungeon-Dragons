package fr.campus.dnd.game;
import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Magician;
import fr.campus.dnd.game.characters.Warrior;
import fr.campus.dnd.game.db.ConnectionDB;

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
        Character character = null;
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
            }
        assert character != null;
        character.showCharacter();
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
}


