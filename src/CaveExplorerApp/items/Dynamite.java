package CaveExplorerApp.items;

import CaveExplorerApp.CaveExplorer;
import CaveExplorerApp.Room;
import CaveExplorerApp.Inventory;
import CaveExplorerApp.globals.Usable;

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

        if(playerRoom.isAdjacentToRoom(roomExit) && playerInventory.contains("flint")){
            roomExit.setLocked(false);
            return "You blow stuff up";
        }

       return "Did not blow stuff up.";
    }

}
