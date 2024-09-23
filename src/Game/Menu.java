package Game;
import Game.Character_settings.Character;
import Game.Character_settings.Magician;
import Game.Character_settings.Warrior;
import java.util.Objects;
import java.util.Scanner;

public class Menu extends Game {
    /*
    Trouver comment stopper le programme
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
                break;
            default:
                System.out.println("Sorry, that is not a valid option!");
        }
    }
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

    /*
    Lancer la partie
     */
}


