import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.exceptions.PersonnageHorsPlateauException;
import fr.campus.dnd.game.Menu;
import fr.campus.dnd.game.Game;


public class Main {
    public static void main(String[] args) {

        ///////////////////////////////// Instantiation and initialization needed to start the game /////////////////////////////

        Game game = new Game();
        Menu menu = new Menu();
        int [] board = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};

       ///////////////////////////////// Initialize board and character with methods ///////////////////////////////////////

        menu.StartMenu();
        Character character = menu.createCharacter();

        /////////////////////////////// Playing the game until the end or death //////////////////////////////////////////
        for (int i =0; i<board.length; i++) {

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