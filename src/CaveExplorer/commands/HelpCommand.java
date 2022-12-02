package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class HelpCommand extends MasterCommand implements CommandWithParameter {

    private CommandList commandList;
    public HelpCommand(Game game, String name, ArrayList<String> synonyms, CommandList commandList) {
        super(game, name, synonyms);
        this.commandList = commandList;
    }

    public HelpCommand(Game game, String name, CommandList commandList) {
        super(game,name);
        this.commandList = commandList;
    }

    @Override
    public String execute(String... parameters) {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            //TODO - Print list of all commands
            case 0 -> returnString = commandList.getCommandList();
            //TODO - Print details for a specific command
            case 1 ->  returnString = commandList.getCommandDetails(parameters[0]);
            default -> returnString = "Too many parameters";
        }

        return returnString;
    }
}
