import Game.Character_settings.Character;
import Game.Menu;
import Game.Game;

import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu();
        Scanner characterInput = new Scanner(System.in);

        System.out.println("Saisissez votre nom");
        String name = characterInput.nextLine();

        System.out.println("Saisissez votre classe");
        String job = characterInput.nextLine();

        Character test = new Character(name, job);

        System.out.println("Congrats ! Your character is valid ! Your name is "+ test.getName() + " and your job is "+ test.getJob());
        System.out.println("Points de vie : " + test.getLifePoints());
        System.out.println("Attaque : "+ test.getStrength());
        System.out.println("Arme : " + test.getOffensiveWeapon());
        System.out.println("Défense : "+ test.getDefensiveWeapon());

        game.mouvement(game.getBoard());
    }
}