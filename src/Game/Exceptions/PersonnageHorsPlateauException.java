package Game.Exceptions;

public class PersonnageHorsPlateauException extends Exception {

    public PersonnageHorsPlateauException() {
        super();
    }
    public PersonnageHorsPlateauException(String s) {
        super(s);
    }

}
/*
public class TestException {
    public static void control (int i) throws PersonnageHorsPlateauException {
        if (i > 64){
            throw new PersonnageHorsPlateauException("Vous sortez du plateau !");
        }
    }
    public static void main(String[] args) {
        int i = 26;
        int j = 68;
        try {
            control(i);
        }
        catch (PersonnageHorsPlateauException e) {
            System.out.println("i est en dehors du plateau");
        }
        try {
            control(j);
        }
        catch (PersonnageHorsPlateauException e) {
            System.out.println("j est en dehors du plateau");
        }
    }
}
*/





