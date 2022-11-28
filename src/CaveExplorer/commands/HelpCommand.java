package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class HelpCommand extends MasterCommand implements CommandWithParameter {

    public HelpCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game, name, synonyms);
    }

    public HelpCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            //TODO - Print list of all commands
            case 0 -> returnString = "List of all commands";
            //TODO - Print details for a specific command
            case 1 ->  returnString = "Details about the " + parameters[0] + " command";
            default -> returnString = "Too many parameters";
        }

        return returnString;
    }
}
