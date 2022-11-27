package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class LookCommand extends MasterCommand implements CommandWithParameter {

    public LookCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public LookCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String... parameters) {
        int parameterLength;
        int parametersLength;

        parametersLength = ((parameters == null) ? 0 : parameters.length);

        switch (parametersLength) {
            case 0:
                return game.playerLook();
            case 1:
                return game.playerLookAt(parameters[0]);
            default:
                return "Too many parameters";
        }

    }
}
