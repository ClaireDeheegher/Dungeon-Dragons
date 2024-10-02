package fr.campus.dnd.game.boardTile;

import fr.campus.dnd.game.items.consumable.BigPotion;
import fr.campus.dnd.game.items.consumable.Potion;
import fr.campus.dnd.game.items.consumable.SmallPotion;
import fr.campus.dnd.game.items.Item;
import fr.campus.dnd.game.items.offensiveEquipment.*;

public class BonusTile extends Tile {
    // /////////////////////  Attributes  //////////////////////// //
    private Item bonusItem = new Item();
    // /////////////////////  Constructors  //////////////////////// //
    public BonusTile() {

    }
    public BonusTile(int i) {
        super(i);
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
        int max = 8;
        int range = max - min + 1;
        int generator =(int)(Math.random()*range)+1;
        bonusItem = switch (generator) {
            case 1 -> new Fireball();
            case 2 -> new Thunder();
            case 3 -> new Sword();
            case 4 -> new Mace();
            case 5 -> new SmallPotion();
            case 6 -> new BigPotion();
            case 7 -> new IronBow();
            case 8 -> new CompoundBow();
            default -> bonusItem;
        };
        return bonusItem;
    }
}
