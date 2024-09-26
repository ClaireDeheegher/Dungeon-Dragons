import Game.Character_settings.Character;
import Game.Menu;
import Game.Game;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu();

        menu.StartMenu();
        Character character = menu.createCharacter();
        character.showCharacter();


        game.startGame(game.getBoard());
    }
}