package Game;

import Game.Exceptions.PersonnageHorsPlateauException;

public class Game {

    // /////////////////////  Attributes  ///////////////////// //

    private int[] board = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64};

    // /////////////////////  Getter  ///////////////////// //

    public int[] getBoard() {
        return board;
    }

    // /////////////////////  Setter  ///////////////////// //

    public void setBoard(int[] board) {
        this.board = board;
    }

    // /////////////////////  Methods  ///////////////////// //

    /**
     * Méthode permettant de générer le déroulement du jeu
     */

    public void startGame (int [] board){
        int boardTile =0;
        for (int i = 0; i < board.length; i++) {
            int dice1 = trowDice();
            int dice2 = trowDice();
            boardTile = getMoving(boardTile, dice1, dice2);
            try {
                outOfBounds(boardTile);
            }
            catch(PersonnageHorsPlateauException e){
                System.out.println("Le dé est tombé sur "+ dice1 + " et "+dice2+". Vous êtes arrivé à la sortie ! Félicitations vous n'êtes pas des noobs");
                break;
            }
            System.out.println("Les dés ont fait " +dice1+" et "+dice2+ " ! Vous tombez sur la case "+boardTile);
        }
    }


    /**
     * Méthode permettant de générer le jet de dé et son résultat
     * @return le résultat d'un dé
     */
    public int trowDice(){
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int dice = (int)(Math.random()*range)+1;
        return dice;
    }

    /**
     * Méthode permettant d'effecter le déplacement
     * Appelle @throwDice() pour faire les jetées de dé
     * @param caseBoard (case sur laquelle se trouve le personnage au moment du lancer de dé)
     * @return le déplacement effectué par le personage
     */
    public int getMoving (int caseBoard, int dice1, int dice2){
        return caseBoard + dice1+dice2;
    }


    public void outOfBounds(int i) throws PersonnageHorsPlateauException {
        if(i>64){
            throw new PersonnageHorsPlateauException("Vous sortez du plateau !");
        }
    }

}
