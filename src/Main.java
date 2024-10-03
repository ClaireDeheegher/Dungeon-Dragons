import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.db.ConnectionDB;
import fr.campus.dnd.game.exceptions.PersonnageHorsPlateauException;
import fr.campus.dnd.game.Menu;
import fr.campus.dnd.game.Game;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        ///////////////////////////////// Instantiation and initialization needed to start the game /////////////////////////////


        Game game = new Game();
        Menu menu = new Menu();


       ///////////////////////////////// Initialize board and character with methods ///////////////////////////////////////

        menu.startMenu();
        Character character = menu.createCharacter();
        character.showCharacter();
        game.boardSetup();

        /////////////////////////////// Playing the game until the end or death //////////////////////////////////////////
        while(character.getLifePoints()>0) {

            game.playATurn(character);
            menu.continueMenu(character);
        }

    }
}