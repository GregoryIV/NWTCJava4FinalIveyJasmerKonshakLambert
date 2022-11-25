package CaveExplorer.Commands;

import CaveExplorer.Game;
import CaveExplorer.Inventory;
import CaveExplorer.Item;

import java.util.ArrayList;
import java.util.List;

public class LookAtCommand extends MasterCommand implements DoubleCommand{

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
