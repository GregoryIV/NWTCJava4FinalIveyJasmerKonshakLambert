package CaveExplorer;

import CaveExplorer.globals.*;
import CaveExplorer.items.Item;

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
     * @param item - the item to take
     * @return - A message to the user whether the item was grabbed or not.
     */
    public String takeItem(String item) {
        Item i;
        String returnString;

        i = findItemInRoom(item);

        if (i == null) {
            returnString = "There is no " + item + " to take";
        } else {
            giveItemToInventory(currentRoom.getInventory(), i);
            returnString = "You take the " + item;
        }

        return returnString;
    }

    /**
     * Uses an item
     * (swings a pickaxe, blows up dynamite)
     *
     * @param item - the item to use
     * @return - message to the user about the results of the use.
     */
    public String useItem(String item) {
        Item i;
        String returnString;

        i = getInventory().findItemByString(item);

        if (i == null) {
            returnString = "You have no " + item + " to use";
        } else {
            if (i instanceof Usable) {
                returnString = ((Usable)i).use();
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
     * @param itemToUse - the item to be used
     * @param itemToUseOn - the item to be used on
     * @return - message to the user about the results of the use.
     */
    public String useItemOn(String itemToUse, String itemToUseOn) {
        Item i, i1;
        String returnString;

        i = getInventory().findItemByString(itemToUse);
        i1 = getInventory().findItemByString(itemToUseOn);

        if (i1 == null) {
            i1 = findItemInRoom(itemToUseOn);
        }

        if (i == null) {
            returnString = "You have no " + itemToUse + " to use";
        } else if (i1 == null) {
            returnString = "There is no " + itemToUseOn + " to use " + itemToUse + " on";
        } else {
            if (i instanceof UsableOn) {
                returnString = ((UsableOn)i).useOn(i1);
                if (i.isConsumedOnUse()) {
                    removeInventoryItem(i);
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
     * @param item - the item to drop
     * @return message to the user about the drop
     */
    public String dropItem(String item) {
        Item i;
        String returnString;

        i = getInventory().findItemByString(item);

        if (i == null) {
            returnString = "You have no " + item + " to drop";
        } else {
            receiveItemFromInventory(currentRoom.getInventory(), i);
            returnString = "You drop the " + item;
        }

        return returnString;
    }

    /**
     * Searches the current rooms inventory for an item
     * 2.2 valid use of encapsulation
     * @param item - item to find in the room
     * @return - Item if found,
     *           Null if the item is not in the room.
     */
    private Item findItemInRoom(String item) {
        return currentRoom.findItem(item);
    }

}
