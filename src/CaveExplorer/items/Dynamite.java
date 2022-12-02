package CaveExplorer.items;

import CaveExplorer.CaveExplorer;
import CaveExplorer.Room;
import CaveExplorer.Inventory;
import CaveExplorer.globals.Usable;

public class Dynamite extends Item implements Usable {
    private Room roomExit;

    public Dynamite(String name, String description, boolean isConsumedOnUse, Room roomExit) {
        super(name, description, isConsumedOnUse);
        this.roomExit = roomExit;
    }

    @Override
    public String use()
    {
        Room playerRoom = CaveExplorer.game.getPlayerRoom();
        Inventory playerInventory = CaveExplorer.game.getPlayerInventory();

        if(playerRoom.getName().equals("Cave Entrance") && playerInventory.containsItemByString("flint")){
            roomExit.setLocked(false);
            return "You blow stuff up";
        }

       return "Did not blow stuff up.";
    }

}
