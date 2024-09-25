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

    public void mouvement(int[] board){
        int deplacement = 0;
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        for(int i = 0; i < board.length; i++){
            int dice = (int)(Math.random()*range)+1;
            deplacement+=dice;
            try {
               outOfBounds(deplacement);
            }
            catch(PersonnageHorsPlateauException e){
                System.out.println("Le dé est tombé sur "+ dice +". Vous êtes arrivé à la sortie ! Félicitations vous n'êtes pas des noobs");
                break;
            }
            System.out.println("Vous bougez de " +dice+ " cases ! Vous tombez sur la case "+deplacement);

        }
    }
    public void outOfBounds(int i) throws PersonnageHorsPlateauException {
        if(i>64){
            throw new PersonnageHorsPlateauException("Vous sortez du plateau !");
        }
    }

}
