package CaveExplorerApp.commands;

import CaveExplorerApp.Game;
import CaveExplorerApp.exceptions.GameCommandErrorException;

import java.util.ArrayList;

public class HelpCommand extends Command implements GameCommand {

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
    public String execute(String... parameters) throws GameCommandErrorException {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> returnString = commandList.getCommandList();
            case 1 ->  returnString = commandList.getCommandDetails(parameters[0]);
            default -> throw new GameCommandErrorException("Too many parameters");
        }

        return returnString;
    }
}
