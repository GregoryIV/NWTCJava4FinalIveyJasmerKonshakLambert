package CaveExplorer.commands;

import CaveExplorer.Game;
import CaveExplorer.commands.Command;

import java.util.ArrayList;

public abstract class MasterCommand implements Command {
    Game game;
    String name;
    ArrayList<String> synonyms;

    public MasterCommand(Game game, String name, ArrayList<String> synonyms) {
        this.game = game;
        this.name = name;
        this.synonyms = synonyms;
    }

    public MasterCommand(Game game, String name) {
        this.game = game;
        this.name = name;
        synonyms = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    @Override
    public void addSynonym(String synonym) {
        synonyms.add(synonym);
    }

    @Override
    public boolean containsSynonym(String synonym) {
        return synonyms.contains(synonym);
    }
}
