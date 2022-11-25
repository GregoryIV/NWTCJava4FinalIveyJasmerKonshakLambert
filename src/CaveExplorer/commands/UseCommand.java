package CaveExplorer.commands;

import CaveExplorer.Game;

import java.util.ArrayList;

public class UseCommand extends MasterCommand implements CommandWithParameter{

    public UseCommand(Game game, String name, ArrayList<String> synonyms) {
        super(game,name,synonyms);
    }

    public UseCommand(Game game, String name) {
        super(game,name);
    }

    @Override
    public String execute(String parameter) {
        return game.playerUseItem(parameter);
    }
}
