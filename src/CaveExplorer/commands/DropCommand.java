package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class DropCommand extends MasterCommand implements CommandWithParameter{

    public DropCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public DropCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> returnString = "The drop command is requires 1 item";
            case 1 -> returnString = game.playerDropItem(parameters[0]);
            default -> returnString = "Too many parameters";

        }

        return returnString;
    }
}
