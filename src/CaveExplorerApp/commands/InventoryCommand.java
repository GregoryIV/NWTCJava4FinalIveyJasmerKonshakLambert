package CaveExplorerApp.commands;

import CaveExplorerApp.Game;
import CaveExplorerApp.exceptions.GameCommandErrorException;

import java.util.ArrayList;

public class InventoryCommand extends Command implements GameCommand {

    public InventoryCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public InventoryCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) throws GameCommandErrorException {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> returnString = game.ShowPlayerInventory();
            default -> throw new GameCommandErrorException("Too many parameters");
        }

        return returnString;
    }
}