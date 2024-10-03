package fr.campus.dnd.game.boardTile;

import fr.campus.dnd.game.characters.Character;
import fr.campus.dnd.game.characters.Hunter;
import fr.campus.dnd.game.characters.Magician;
import fr.campus.dnd.game.characters.Warrior;
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
    public void getItemEffect(Character hero, Item item) {
        if (item instanceof Potion) {
            hero.regenHP((Potion) item);
        }
        if (item instanceof OffensiveWeapon){
            if (item instanceof Spell && hero instanceof Magician){
                hero.switchOffensiveWeapon((Spell) item);
            }
            else if (item instanceof Weapon && hero instanceof Warrior){
                hero.switchOffensiveWeapon((Weapon) item);
            }
            else if (item instanceof Bow && hero instanceof Hunter){
                hero.switchOffensiveWeapon((Bow) item);
            }
            else {
                System.out.println("This equipment is not suitable for your class ! You throw it angrily to the ground and continue your journey !");
            }
        }
    }
}
