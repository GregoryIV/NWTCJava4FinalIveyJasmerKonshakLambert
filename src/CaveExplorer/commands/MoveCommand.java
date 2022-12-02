package CaveExplorer.commands;

import CaveExplorer.Direction;
import CaveExplorer.Game;

import java.util.ArrayList;

public class MoveCommand extends MasterCommand implements CommandWithParameter {

    public MoveCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public MoveCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        Direction d;
        String returnString = "";
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0:
                returnString = "The move command requires a direction.";
                break;
            case 1:

                d = Direction.findByString(parameters[0]);

                if (d != null) {
                    returnString = game.MovePlayer(d);
                } else {
                    returnString = parameters[0] + " is not a direction to move.";
                }
                break;
            default:
                returnString = "Too many parameters";
                break;
        }

        return returnString;
    }
}
