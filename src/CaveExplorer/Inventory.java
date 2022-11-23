package CaveExplorer;

import java.util.ArrayList;

public class Inventory extends ArrayList<Item> {

    public Item findItemByString(String item){
        for (Item i: this) {
            if (i.getName().equals(item)) {
                return i;
            }
        }

        return null;
    }

}
