package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class UseCommand extends MasterCommand implements CommandWithParameter{

    public UseCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public UseCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 1:
                returnString = game.playerUseItem(parameters[0]);
                break;
            default:
                returnString = "Too many parameters";

        }

        return returnString;
    }
}
