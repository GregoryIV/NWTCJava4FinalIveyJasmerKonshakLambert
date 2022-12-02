package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class TakeCommand extends MasterCommand implements GameCommand {

    public TakeCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public TakeCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> returnString = "The take command needs 1 parameter";
            case 1 -> returnString = game.playerTakeItem(parameters[0]);
            default -> returnString = "Too many parameters";
        }

        return returnString;
    }
}
