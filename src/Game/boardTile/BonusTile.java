package Game.boardTile;

import Game.Items.Consumable.BigPotion;
import Game.Items.Consumable.SmallPotion;
import Game.Items.Item;
import Game.Items.OffensiveEquipment.Fireball;
import Game.Items.OffensiveEquipment.Mace;
import Game.Items.OffensiveEquipment.Sword;
import Game.Items.OffensiveEquipment.Thunder;

public class BonusTile extends Tile {
    // /////////////////////  Attributes  //////////////////////// //
    private Item bonusItem = new Item();
    // /////////////////////  Constructors  //////////////////////// //
    public BonusTile() {
    }

    // /////////////////////  Getter  //////////////////////// //

    public Item getBonusItem() {
        return bonusItem;
    }


    // /////////////////////  Setter  //////////////////////// //
    public void setBonusItem(Item bonusItem) {
        this.bonusItem = bonusItem;
    }
    // /////////////////////  Methods  //////////////////////// //
    public Item getItem() {
        Item bonusItem = new Item();
        int min = 1;
        int max = 6;
        int range = max - min + 1;
        int generator =(int)(Math.random()*range)+1;
        bonusItem = switch (generator) {
            case 1 -> new Fireball();
            case 2 -> new Thunder();
            case 3 -> new Sword();
            case 4 -> new Mace();
            case 5 -> new SmallPotion();
            case 6 -> new BigPotion();
            default -> bonusItem;
        };
        return bonusItem;
    }
}
