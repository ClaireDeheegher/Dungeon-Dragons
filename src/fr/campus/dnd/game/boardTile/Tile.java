package fr.campus.dnd.game.boardTile;

public class Tile {

    // /////////////////////  Attributes  //////////////////////// //

    private int number;


    // /////////////////////  Constructor  //////////////////////// //

    public Tile() {}

    public Tile (int number){
        this.number = number;
    }

    // /////////////////////  Getter  //////////////////////// //

    public int getNumber() {
        return number;
    }

    // /////////////////////  Setter  //////////////////////// //

    public void setNumber(int number) {
        this.number = number;
    }


    // /////////////////////  Methods  //////////////////////// //

    @Override
    public String toString() {
        return "Tile{" +
                "number=" + number +

                '}';
    }
}
