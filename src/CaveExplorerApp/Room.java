package CaveExplorerApp;

import CaveExplorerApp.globals.Direction;
import CaveExplorerApp.globals.ItemHolder;
import CaveExplorerApp.items.Item;

/**
 * Represents a room in the game.
 * The room can have four exits (North,South,East,West)
 * Objects will be able to move around rooms.
 */
public class Room extends ItemHolder {
    //Stores the rooms for all four cardinal directions
    private Room northRoom,southRoom,eastRoom, westRoom;

    //Rooms locked are not able to be accessed
    private boolean isLocked;

    //Rooms status for being locked
    private String lockedStatus;

    //Is this room a game exit.
    private boolean isGameExit;

    /**
     * Constructor
     *
     * @param builder - Builder method for creating the room object
     */
    private Room(RoomBuilder builder)
    {
        super(builder.name, builder.description);
        this.isGameExit = builder.isGameExit;
        this.isLocked = builder.isLocked;
        this.lockedStatus = builder.lockedStatus;
    }

    /**
     * Builder method for creating a Room object.
     *
     * 2.? Design pattern - Builder Pattern
     */
    public static class RoomBuilder{
        private String name;
        private String description;

        private Room northRoom,southRoom,eastRoom, westRoom;
        private boolean isLocked = false;
        private String lockedStatus = "";
        private boolean isGameExit = false;

        public RoomBuilder(String description, String name){
            this.name = name;
            this.description = description;
        }

        public RoomBuilder setIsLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public RoomBuilder setLockedStatus(String lockedStatus) {
            this.lockedStatus = lockedStatus;
            return this;
        }

        public RoomBuilder setIsGameExit(boolean isGameExit) {
            this.isGameExit = isGameExit;
            return this;
        }

        /**
         * Builds the room object.
         *
         * @return Room
         */
        public Room build(){
            return new Room(this);
        }

    }

    /**
     * Initializes the rooms and inventory
     * Used to set the rooms exits after the rooms have been created.
     *
     * @param northRoom - Room to the north.
     * @param southRoom - Room to the south.
     * @param eastRoom - Room to the east.
     * @param westRoom - Room to the west.
     * @param inventory - Inventory for this room.
     */
    public void initializeRoom(Room northRoom, Room southRoom,
                          Room eastRoom, Room westRoom, Inventory inventory) {
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
        setInventory(inventory);
    }

    /**
     *
     * @return
     */
    public Room getEastRoom() {
        return eastRoom;
    }

    /**
     *
     * @return
     */
    public Room getNorthRoom() {
        return northRoom;
    }

    /**
     *
     * @return
     */
    public Room getSouthRoom() {
        return southRoom;
    }

    /**
     *
     * @return
     */
    public Room getWestRoom() {
        return westRoom;
    }

    /**
     * Tells if room is adjacent to another room.
     *
     * @param room - Room to test if adjacent to this.
     * @return - True if the room is adjacent to this.
     *           False if the room is not adjacent to this.
     */
    public boolean isAdjacentToRoom(Room room) {
        boolean isAdjacent = false;

        if (northRoom != null && northRoom.equals(room) ||
            southRoom != null && southRoom.equals(room) ||
            eastRoom != null && eastRoom.equals(room) ||
            westRoom != null && westRoom.equals(room)) {
            isAdjacent = true;
        }

        return isAdjacent;

    }

    /**
     *  Is the room locked
     *
     * @return Locked status.
     */
    public boolean getLocked() {return isLocked;}

    /**
     * Sets the lock/unlock on room
     *
     * @param isLocked - Is the room locked
     */
    public void setLocked(boolean isLocked) {this.isLocked = isLocked;}

    /**
     * Gets details about a locked room.
     *
     * @return - Locked room status.
     */
    public String getLockedStatus() {return lockedStatus;}

    /**
     * Gets details about a room in a given direction.
     *
     * @param direction - A direction to look.
     * @return - The rooms description if there is a room to the given direction.
     *           Message to the user if the player can't look in the given direction.
     */
    public String getRoomDescriptionByDirection (String direction) {
        Direction directionToLook = Direction.findByString(direction);
        String returnString;

        switch (directionToLook) {
            case North -> returnString = getRoomExitDescription(northRoom);
            case East -> returnString = getRoomExitDescription(eastRoom);
            case West -> returnString = getRoomExitDescription(westRoom);
            case South -> returnString = getRoomExitDescription(southRoom);
            default -> returnString = direction + " is not a valid direction";
        }

        return returnString;
    }

    /**
     * Gets the description of a room exit (north,south,east,west).
     *
     * @param roomExit - The room exit (north,south,east,west)
     * @return - The rooms description if it exists/
     *           No exit if the room is null.
     */
    public String getRoomExitDescription(Room roomExit) {
        if (roomExit == null) {
            return "There is no exit.";
        } else {
            return roomExit.getDescription();
        }

    }

    /**
     * Gets whether to room is an exit or not.
     * An exit will end the game.
     *
     * @return
     */
    public boolean isGameExit() {return isGameExit;}

    /**
     * Finds an item in the room's inventory.
     *
     * @param itemName - Name of the item that is trying to be found.
     * @return - The item if it is found.
     *           Null if the item is not found
     */
    public Item findItem(String itemName) {
        return getInventory().findItemByString(itemName);
    }
}
