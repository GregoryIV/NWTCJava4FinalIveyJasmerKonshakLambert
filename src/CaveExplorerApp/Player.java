package CaveExplorerApp;

import CaveExplorerApp.globals.*;
import CaveExplorerApp.items.Item;

/**
 * Represents a player in the game from a first-person perspective.
 */
public class Player extends ItemHolder implements Movable {

    //The current room that the player is in
    private Room currentRoom;

    /**
     * Player constructor
     *
     * @param name The players name
     * @param description A brief description of the player
     * @param currentRoom The current room the player is in
     * @param inventory The players current inventory
     */
    public Player(String name, String description, Room currentRoom, Inventory inventory) {
        super(name, description, inventory);
        this.currentRoom = currentRoom;
    }
    public Player(String name, String description, Room currentRoom) {
        super(name, description);
        this.currentRoom = currentRoom;
    }

    /**
     * Gets the description of the current room.
     *
     * @return The player's current room description.
     */
    public String look() {
        return currentRoom.getDescription();
    }

    /**
     * Gets the description of an object.
     *
     * @param gameObject The game object that is being described.
     * @return The game objects description.
     */
    public String lookAt(String gameObject) {
        GameObject go;
        String returnString = "";

        //Find object in player inventory
        go = getInventory().findItemByString(gameObject);

        if (go != null) {
            return go.getDescription();
        }

        //Find object in current room
        go = currentRoom.getInventory().findItemByString(gameObject);

        if (go != null) {
            return go.getDescription();
        }


        //Check if direction
        if (Direction.findByString(gameObject) != null) {
            return currentRoom.getRoomDescriptionByDirection(gameObject);
        }

        return "There is no " + gameObject + " in your inventory, or in the room.";
    }

    /**
     * Gets the current room
     *
     * @return Current Room
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Sets the current room
     *
     * @param currentRoom The room that will be set to the current room
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Tries to move the player in a given direction.
     * Currently, there are 2 ways the player can not move. There is no room to
     * the given direction, or the room is locked off.
     *
     * @param direction A direction to move (North, South, East, West)
     * @return A String describing the results of the movement.
     */
    @Override
    public String move(Direction direction) {
        Room exitRoom;
        String returnString;

        //Gets the room to the direction given. ie The room east of the current room.
        switch (direction) {
            case East -> exitRoom = currentRoom.getEastRoom();
            case West -> exitRoom = currentRoom.getWestRoom();
            case North -> exitRoom = currentRoom.getNorthRoom();
            case South -> exitRoom = currentRoom.getSouthRoom();
            default -> exitRoom = null;
        }
        
        if (exitRoom == null) {
            returnString = "There is no exit to the " + direction.name().toLowerCase();
        } else if (exitRoom.getLocked()) {
            returnString = exitRoom.getLockedStatus();
        } else
        {
            currentRoom = exitRoom;
            returnString = exitRoom.getDescription();
        }

        return returnString;
    }

    /**
     * Gets a list of all item's in the players inventory
     *
     * @return - String list of items in the players inventory.
     */
    public String printInventory() {
        return getInventoryList();
    }

    /**
     *Takes an item from the room and places it in the player's inventory
     *
     * @param itemName - the item to take
     * @return - A message to the user whether the item was grabbed or not.
     */
    public String takeItem(String itemName) {
        Item itemToTake;
        String returnString;

        itemToTake = findItemInRoom(itemName);

        if (itemToTake == null) {
            returnString = "There is no " + itemName + " to take";
        } else {
            receiveItemFromInventory(currentRoom.getInventory(), itemToTake);
            returnString = "You take the " + itemName;
        }

        return returnString;
    }

    /**
     * Uses an item
     * (swings a pickaxe, blows up dynamite)
     *
     * @param itemName - the item to use
     * @return - message to the user about the results of the use.
     */
    public String useItem(String itemName) {
        Item itemToUse;
        String returnString;

        itemToUse = getInventory().findItemByString(itemName);

        if (itemToUse == null) {
            returnString = "You have no " + itemName + " to use";
        } else {
            if (itemToUse instanceof Usable) {
                returnString = ((Usable)itemToUse).use();
            }
            else {
                returnString = "Nothing happens";
            }
        }

        return returnString;
    }

    /**
     * Uses an item on another item
     * (battery on flashlight, key on door)
     *
     * @param nameOfItemToUse - the item to be used
     * @param nameOfItemToUseOn - the item to be used on
     * @return - message to the user about the results of the use.
     */
    public String useItemOn(String nameOfItemToUse, String nameOfItemToUseOn) {
        Item itemToUse, itemToUseOn;
        String returnString;

        itemToUse = getInventory().findItemByString(nameOfItemToUse);
        itemToUseOn = getInventory().findItemByString(nameOfItemToUseOn);

        if (itemToUseOn == null) {
            itemToUseOn = findItemInRoom(nameOfItemToUseOn);
        }

        if (itemToUse == null) {
            returnString = "You have no " + nameOfItemToUse + " to use";
        } else if (itemToUseOn == null) {
            returnString = "There is no " + nameOfItemToUseOn + " to use " + nameOfItemToUseOn + " on";
        } else {
            if (itemToUse instanceof UsableOn) {
                returnString = ((UsableOn)itemToUse).useOn(itemToUseOn);
                if (itemToUse.isConsumedOnUse()) {
                    removeInventoryItem(itemToUse);
                }
            }
            else {
                returnString = "Nothing happens";
            }
        }

        return returnString;
    }

    /**
     * Drops an item from the players inventory to the room's floor
     *
     * @param itemName - the item to drop
     * @return message to the user about the drop
     */
    public String dropItem(String itemName) {
        Item itemToDrop;
        String returnString;

        itemToDrop = getInventory().findItemByString(itemName);

        if (itemToDrop == null) {
            returnString = "You have no " + itemName + " to drop";
        } else {
            giveItemToInventory(currentRoom.getInventory(), itemToDrop);
            returnString = "You drop the " + itemName;
        }

        return returnString;
    }

    /**
     * Searches the current rooms inventory for an item
     * 2.2 valid use of encapsulation
     * @param itemName - item to find in the room
     * @return - Item if found,
     *           Null if the item is not in the room.
     */
    private Item findItemInRoom(String itemName) {
        return currentRoom.findItem(itemName);
    }

}
