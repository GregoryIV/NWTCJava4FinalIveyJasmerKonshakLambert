package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;
import java.util.Optional;

public class InventoryCommand extends MasterCommand implements CommandWithParameter {

    public InventoryCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public InventoryCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0:
                returnString = game.ShowPlayerInventory();
                break;
            default:
                returnString = "Too many parameters";
                break;
        }

        return returnString;
    }
}
