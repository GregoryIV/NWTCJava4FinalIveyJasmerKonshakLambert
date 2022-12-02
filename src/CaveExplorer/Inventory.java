package CaveExplorer;

import java.util.ArrayList;
import CaveExplorer.items.*;
public class Inventory extends ArrayList<Item> {

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
