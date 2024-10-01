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

        menu.StartMenu();
        Character character = menu.createCharacter();
        game.boardSetup();

        /////////////////////////////// Playing the game until the end or death //////////////////////////////////////////
        for (int i =0; i<100; i++) {

            game.playATurn(character);
            try {
                game.outOfBounds();
            }
            catch(PersonnageHorsPlateauException e) {
                System.out.println("You arrived at the end of the dungeon ! Congrats you're not a noob :)");
                break;
            }
            menu.ContinueMenu(character);
        }

    }
}