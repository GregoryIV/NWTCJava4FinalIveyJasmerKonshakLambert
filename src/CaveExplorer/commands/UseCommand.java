package CaveExplorer.commands;

import CaveExplorer.Game;
import CaveExplorer.exceptions.GameCommandErrorException;

import java.util.ArrayList;

public class UseCommand extends Command implements GameCommand {

    public UseCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public UseCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) throws GameCommandErrorException {
        String returnString;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> throw new GameCommandErrorException( "The use command requires at 1 item");
            case 1 -> returnString = game.playerUseItem(parameters[0]);
            case 2 -> returnString = game.playerUseItemOn(parameters[0],parameters[1]);
            default -> throw new GameCommandErrorException("Too many parameters");
        }

        return returnString;
    }
}
