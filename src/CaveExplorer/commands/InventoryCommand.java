package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class InventoryCommand extends MasterCommand implements SingleCommand {

    public InventoryCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public InventoryCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute() {
        return game.ShowPlayerInventory();
    }
}
