package CaveExplorerApp.commands;

import CaveExplorerApp.Game;
import CaveExplorerApp.exceptions.GameCommandErrorException;

import java.util.ArrayList;

public class TakeCommand extends Command implements GameCommand {

    public TakeCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public TakeCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) throws GameCommandErrorException {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> throw new GameCommandErrorException("The take command needs 1 parameter");
            case 1 -> returnString = game.playerTakeItem(parameters[0]);
            default -> throw new GameCommandErrorException("Too many parameters");
        }

        return returnString;
    }
}
