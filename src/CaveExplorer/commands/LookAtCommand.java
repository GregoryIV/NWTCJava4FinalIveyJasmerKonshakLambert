package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class LookAtCommand extends MasterCommand implements CommandWithParameter {

    public LookAtCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public LookAtCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String parameter) {
        return game.playerLookAt(parameter);
    }
}
