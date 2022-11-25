package CaveExplorer;

public abstract class ItemHolder extends GameObject {

    private Inventory inventory;

    public ItemHolder(String name, String description, Inventory inventory) {
        super(name, description);

        this.inventory = inventory;
    }

    public ItemHolder(String name, String description) {
        super(name, description);

        this.inventory = new Inventory();
    }

    public String getInventoryList() {
        StringBuilder inventoryList = new StringBuilder("");

        inventoryList.append(getName() + "'s inventory\n");

        inventory.forEach(item -> {
            inventoryList.append(item.getName() + "\n");
        });

        return inventoryList.toString().trim();
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addInventoryItem(Item item) {
        inventory.add(item);
    }

    public boolean removeInventoryItem(Item item) {
        return inventory.remove(item);
    }

    public void receiveItemFromInventory(Inventory receivingInventory, Item transferItem ) {
        Item tempItem = transferItem;

        removeInventoryItem(transferItem);
        receivingInventory.add(tempItem);
    }

    public void giveItemToInventory(Inventory givingInventory, Item transferItem ) {
        Item tempItem = transferItem;

        givingInventory.remove(transferItem);
        addInventoryItem(tempItem);
    }

    public Inventory getInventory() {return inventory;}
}
