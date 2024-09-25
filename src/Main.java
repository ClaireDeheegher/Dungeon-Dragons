import Game.Character_settings.Character;
import Game.Menu;
import Game.Game;

import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu();



        /*menu.StartMenu();
        Character character = menu.createCharacter();
        character.showCharacter();*/


        game.mouvement(game.getBoard());
    }
}