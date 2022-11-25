package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class TakeCommand extends MasterCommand implements CommandWithParameter {

    public TakeCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public TakeCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String parameter) {
        return game.playerTakeItem(parameter);
    }
}
