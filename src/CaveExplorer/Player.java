package CaveExplorer;

import java.util.ArrayList;

public class Player extends GameObject{

    private Room currentRoom;
    private ArrayList<Item> inventory;
    public Player(String name, String description, Room currentRoom, ArrayList<Item> inventory) {
        super(name, description);
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }
    public String look(GameObject gameObject) {
        return gameObject.getDescription();
    }
    public String move(Direction direction) {
        Room exitRoom;
        String returnString;

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
}
