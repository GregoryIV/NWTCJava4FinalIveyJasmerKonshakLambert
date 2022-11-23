package CaveExplorer;

public class Room extends ItemHolder {
    //Stores the rooms for all four cardinal directions
    private Room northRoom,southRoom,eastRoom, westRoom;

    //Rooms locked are not able to be accessed
    private boolean isLocked;

    private String lockedStatus;

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
                          Room eastRoom, Room westRoom, Inventory inventory) {
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
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

    public boolean getLocked() {return isLocked;}

    public void setLocked(boolean isLocked) {this.isLocked = isLocked;}

    public String getLockedStatus() {return lockedStatus;}
    public void setLockedStatus(String lockedStatus) {this.lockedStatus = lockedStatus;}
}
