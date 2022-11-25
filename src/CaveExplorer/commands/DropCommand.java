package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class DropCommand extends MasterCommand implements CommandWithParameter{

    public DropCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public DropCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String parameter) {
        return game.playerDropItem(parameter);
    }
}
