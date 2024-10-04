import fr.campus.dnd.game.boardTile.Tile;
import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.environment.Biome;
import fr.campus.dnd.game.Menu;
import fr.campus.dnd.game.Game;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ///////////////////////////////// Instantiation and initialization needed to start the game /////////////////////////////


        Game game = new Game();
        Menu menu = new Menu();
        Biome field = new Biome();
        ArrayList<Tile> board = field.generateBoard();;



       ///////////////////////////////// Initialize board and character with methods ///////////////////////////////////////

        menu.startMenu();
        Character character = menu.createCharacter();
        character.showCharacter();


        /////////////////////////////// Playing the game until the end or death //////////////////////////////////////////
        while(character.getLifePoints()>0) {

            game.playATurn(character, board);
            menu.continueMenu(character);
        }

    }
}