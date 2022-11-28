package CaveExplorer;

/**
 * Represents a player in the game from a first-person perspective.
 */
public class Player extends ItemHolder implements Movable{

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
     * TODO Implement a look method
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

    public String printInventory() {
        return getInventoryList();
    }

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

    public String useItem(String item) {
        Item i;
        String returnString;

        i = getInventory().findItemByString(item);

        if (i == null) {
            returnString = "You have no " + item + " to use";
        } else {
            returnString = i.Use();
        }

        return returnString;
    }

    public String useItemOn(String itemToUse, String itemToUseOn) {
        return "You use the " + itemToUse + " on " + itemToUseOn;
    }

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

    private Item findItemInRoom(String item) {
        return currentRoom.getInventory().findItemByString(item);
    }

}
