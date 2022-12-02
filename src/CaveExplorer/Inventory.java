package CaveExplorer;

import CaveExplorer.items.Item;

import java.util.ArrayList;
public class Inventory extends ArrayList<Item> {

    public boolean contains(String item){
        for (Item i: this) {
            if (i.getName().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsItemByString(String item){
        for (Item i: this) {
            if (i.getName().equals(item)) {
                return true;
            }
        }
        return false;
    }
    public Item findItemByString(String item){
        for (Item i: this) {
            if (i.getName().equals(item)) {
                return i;
            }
        }

        return null;
    }

}
