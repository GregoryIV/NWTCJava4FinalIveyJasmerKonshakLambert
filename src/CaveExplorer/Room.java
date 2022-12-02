package CaveExplorer;

import CaveExplorer.globals.Direction;
import CaveExplorer.globals.ItemHolder;

public class Room extends ItemHolder {
    //Stores the rooms for all four cardinal directions
    private Room northRoom,southRoom,eastRoom, westRoom;

    //Rooms locked are not able to be accessed
    private boolean isLocked;
    private String lockedStatus;
    private boolean isGameExit;

    public Room() {
        super("","");
        this.northRoom = null;
        this.southRoom = null;
        this.eastRoom = null;
        this.westRoom = null;
    }
    private Room(RoomBuilder builder)
    {
        super(builder.name, builder.description);
        this.isGameExit = builder.isGameExit;
        this.isLocked = builder.isLocked;
        this.lockedStatus = builder.lockedStatus;
    }

    //Builder Class
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

        public RoomBuilder setisGameExit(boolean isGameExit) {
            this.isGameExit = isGameExit;
            return this;
        }

        public Room build(){
            return new Room(this);
        }

    }

    public void initializeRoom(Room northRoom, Room southRoom,
                          Room eastRoom, Room westRoom, Inventory inventory) {
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
        this.isGameExit = isGameExit;
        setInventory(inventory);
    }
    
    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
    }

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

    public boolean getLocked() {return isLocked;}

    public void setLocked(boolean isLocked) {this.isLocked = isLocked;}

    public String getLockedStatus() {return lockedStatus;}
    public void setLockedStatus(String lockedStatus) {this.lockedStatus = lockedStatus;}

    public String getRoomDescriptionByDirection (String direction) {
        Direction d = Direction.findByString(direction);
        String returnString;

        switch (d) {
            case North -> returnString = getRoomExitDescription(northRoom);
            case East -> returnString = getRoomExitDescription(eastRoom);
            case West -> returnString = getRoomExitDescription(westRoom);
            case South -> returnString = getRoomExitDescription(southRoom);
            default -> returnString = direction + " is not a valid direction";
        }

        return returnString;
    }

    public String getRoomExitDescription(Room roomExit) {
        if (roomExit == null) {
            return "There is no exit.";
        } else {
            return roomExit.getDescription();
        }

    }

    public boolean isGameExit() {return isGameExit;}
}
