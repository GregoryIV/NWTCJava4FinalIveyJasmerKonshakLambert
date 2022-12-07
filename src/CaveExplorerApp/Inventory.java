package CaveExplorerApp;

import CaveExplorerApp.items.Item;

import java.util.ArrayList;

/**
 * A list of items
 */
public class Inventory extends ArrayList<Item> {

    /**
     * Checks if an item is in this inventory.
     *
     * @param itemName - Name of the item trying to be found.
     * @return - True if the item is found.
     *           False if the item is not found.
     */
    public boolean contains(String itemName){
        for (Item i: this) {
            if (i.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds an item in this inventory
     *
     * @param itemName - Name of the item to be found.
     * @return - The item if it exists.
     *           Null if the item doesn't exist.
     */
    public Item findItemByString(String itemName){
        for (Item i: this) {
            if (i.getName().equals(itemName)) {
                return i;
            }
        }

        return null;
    }

    /**
     * Override the toString to print out all items in this inventory.
     * @return - List of all items in this inventory.
     */
    @Override
    public String toString() {
        StringBuilder inventory = new StringBuilder();

        // 2.1 use of lambda expression
        this.forEach(item -> {
            inventory.append(item + "\n");
        });

        return inventory.toString().trim();
    }

}
