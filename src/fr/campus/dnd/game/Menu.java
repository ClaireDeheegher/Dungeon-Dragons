package fr.campus.dnd.game;
import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Magician;
import fr.campus.dnd.game.characters.Warrior;

import java.util.Scanner;

public class Menu extends Game {
    /*
    Trouver comment stopper le programme
     */

    /**
     * méthode StartMenu permettant de lancer le jeu.
     */
    public void StartMenu(){
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

        System.out.println("Saisissez votre nom");
        String name = characterInput.nextLine();
        Character character = null;
        System.out.println("Il y a deux classes disponibles: guerrier ou magicien. Taper 1 pour devenir guerrier, 2 pour devenir magicien");
        String job = characterInput.nextLine();
            switch (job){
                case "1":
                    character = new Warrior(name);
                    break;
                case "2":
                    character = new Magician(name);
                    break;
                default:
                    System.out.println("Sorry, that is not a valid option!");
            }
        return character;
    }
    public void ContinueMenu(Character character) {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to go to the next turn ? You can choose yes to continue, no to stop and character to see your stats ! ");
        String answer = input.nextLine();
        switch (answer){
            case "yes" :
                break;
            case "no" :
                System.out.println("Goodbye ! Have a nice day !");
                System.exit(0);
                break;
            case "character":
                character.showCharacter();
                break;
        }

    }
}


