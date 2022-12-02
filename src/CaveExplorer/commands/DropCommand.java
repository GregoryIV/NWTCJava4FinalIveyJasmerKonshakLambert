package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

/**
 *
 * 1.2 example of inheritance and interface
 */
public class DropCommand extends MasterCommand implements GameCommand {

    //1.3 Use of overloaded constructor
    public DropCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public DropCommand(Game game, String name) {
        super(game,name);
    }

    /**
     *
     * 1.4 use of overridden method
     * @param parameters
     * @return
     */
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
