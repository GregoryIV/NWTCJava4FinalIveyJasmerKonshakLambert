package CaveExplorerApp.globals;

import CaveExplorerApp.Inventory;
import CaveExplorerApp.items.Item;

/**
 * Game Object that can hold items
 */
public abstract class ItemHolder extends GameObject {

    //
    private Inventory inventory;

    /**
     * Constructor
     *
     * @param name - Name of the item holder
     * @param description - Description of the item holder
     * @param inventory - List of items
     */
    public ItemHolder(String name, String description, Inventory inventory) {
        super(name, description);

        this.inventory = inventory;
    }

    /**
     * Constructor
     *
     * @param name - Name of the item holder
     * @param description - Description of the item holder
     */
    public ItemHolder(String name, String description) {
        super(name, description);

        this.inventory = new Inventory();
    }

    /**
     * Gets a list of items from the inventory
     *
     * @return - String of items
     */
    public String getInventoryList() {
        StringBuilder inventoryList = new StringBuilder("");

        inventoryList.append(getName() + "'s inventory\n" + inventory);

        return inventoryList.toString().trim();
    }

    /**
     * Sets the inventory
     *
     * @param inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     *
     * @param item
     */
    public void addInventoryItem(Item item) {
        inventory.add(item);
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean removeInventoryItem(Item item) {
        return inventory.remove(item);
    }

    /**
     *
     * @param receivingInventory
     * @param transferItem
     */
    public void giveItemToInventory(Inventory receivingInventory, Item transferItem ) {
        Item tempItem = transferItem;

        removeInventoryItem(transferItem);
        receivingInventory.add(tempItem);
    }

    /**
     *
     * @param givingInventory
     * @param transferItem
     */
    public void receiveItemFromInventory(Inventory givingInventory, Item transferItem ) {
        Item tempItem = transferItem;

        givingInventory.remove(transferItem);
        addInventoryItem(tempItem);
    }

    /**
     *
     * @return
     */
    public Inventory getInventory() {return inventory;}
}
