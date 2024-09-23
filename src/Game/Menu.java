package Game;

import Game.Character_settings.Character;

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
        if(answer.equals("y")){
            System.out.println("Let's create your character !");
        }
        if(answer.equals("n")){
            return;
        }
        else {
            System.out.println("Sorry, that is not a valid option!");
        }
    }
    public Character createCharacter(){
        Scanner characterInput = new Scanner(System.in);

        System.out.println("Saisissez votre nom");
        String name = characterInput.nextLine();

        System.out.println("Il y a deux classes disponibles: guerrier ou magicien. Taper 1 pour devenir guerrier, 2 pour devenir magicien");
        String job = characterInput.nextLine();
        if (!Objects.equals(job, "1") && !Objects.equals(job, "2")) {
            System.out.println("Sorry, that is not a valid option!");
        }
        if (job.equals("1")){
            job = "guerrier";
        }
        if (job.equals("2")){
            job = "magicien";
        }


        Character character = new Character(name, job);
        System.out.println("Congrats ! Your character is valid ! Your name is "+ character.getName() + " and your job is "+ character.getJob());
        return character;
    }

    /*
    Lancer la partie
     */
}


