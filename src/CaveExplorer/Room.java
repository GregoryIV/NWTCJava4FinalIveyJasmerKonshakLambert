package CaveExplorer;

import java.util.ArrayList;

public class Room extends GameObject {
    //Stores the rooms for all four cardinal directions
    private Room northRoom,southRoom,eastRoom, westRoom;

    //Rooms locked are not able to be accessed
    private boolean isLocked;

    private String lockedStatus;

    private ArrayList<Item> items;

    public Room() {
        super("","");
        this.northRoom = null;
        this.southRoom = null;
        this.eastRoom = null;
        this.westRoom = null;
    }
    public Room(String description, String name) {
        super(name,description);
    }

    public void initializeRoom(Room northRoom, Room southRoom,
                          Room eastRoom, Room westRoom, ArrayList<Item> items) {
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
        this.items = items;
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

    public boolean getLocked() {return isLocked;}

    public void setLocked(boolean isLocked) {this.isLocked = isLocked;}

    public String getLockedStatus() {return lockedStatus;}
    public void setLockedStatus(String lockedStatus) {this.lockedStatus = lockedStatus;}
}
