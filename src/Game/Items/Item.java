package Game.Items;

public class Item {
    // /////////////////////  Attributes  //////////////////////// //

    private String name;

    // /////////////////////  Constructors  //////////////////////// //

    public Item (){
        this.name = "";
    }

    // /////////////////////  Getter  //////////////////////// //

    public String getName() {
        return name;
    }

    // /////////////////////  Setter  //////////////////////// //

    public void setName(String name) {
        this.name = name;
    }

    // /////////////////////  Methods  //////////////////////// //

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
