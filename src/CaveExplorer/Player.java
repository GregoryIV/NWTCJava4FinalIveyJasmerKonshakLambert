package CaveExplorer;

import java.util.ArrayList;

/**
 * Represents a player in the game from a first-person perspective.
 */
public class Player extends GameObject implements Movable{

    //The current room that the player is in
    private Room currentRoom;

    //The players inventory
    private ArrayList<Item> inventory;

    /**
     * Player constructor
     *
     * @param name The players name
     * @param description A brief description of the player
     * @param currentRoom The current room the player is in
     * @param inventory The players current inventory
     */
    public Player(String name, String description, Room currentRoom, ArrayList<Item> inventory) {
        super(name, description);
        this.currentRoom = currentRoom;
        this.inventory = inventory;
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
    public String look(String object) {
        GameObject gameObject;
        String returnString = "";

        return "";
    }

    /**
     * Gets the current room
     *
     * @return Current Room
     */
    @Override
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Sets the current room
     *
     * @param currentRoom The room that will be set to the current room
     */
    @Override
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
            case East: 
                exitRoom = currentRoom.getEastRoom();
                break;
            case West:
                exitRoom = currentRoom.getWestRoom();
                break;
            case North:
                exitRoom = currentRoom.getNorthRoom();
                break;
            case South:
                exitRoom = currentRoom.getSouthRoom();
                break;
            default:
                exitRoom = null;
                break;
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

    public boolean findInInventoryByString(String item) {
        return  inventory.contains(item);
    }
}
