package CaveExplorer.commands;

import CaveExplorer.Game;
import CaveExplorer.exceptions.GameCommandErrorException;
import CaveExplorer.globals.Direction;

import java.util.ArrayList;

public class MoveCommand extends Command implements GameCommand {

    public MoveCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public MoveCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) throws GameCommandErrorException {
        Direction d;
        String returnString = "";
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0:
                throw new GameCommandErrorException("The move command requires a direction.");
            case 1:

                d = Direction.findByString(parameters[0]);

                if (d == null) {
                    throw new GameCommandErrorException(parameters[0] + " is not a direction to move.");
                }

                returnString = game.MovePlayer(d);
                break;
            default:
                throw new GameCommandErrorException("Too many parameters");
        }

        return returnString;
    }
}
