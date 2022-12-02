package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class LookCommand extends MasterCommand implements GameCommand {

    public LookCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public LookCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        int parametersLength;
        String returnString;
        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0 -> returnString = game.playerLook();
            case 1 -> returnString = game.playerLookAt(parameters[0]);
            default -> returnString = "Too many parameters";
        }

        return returnString;

    }
}
