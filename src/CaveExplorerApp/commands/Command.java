package CaveExplorerApp.commands;

import CaveExplorerApp.Game;

import java.util.ArrayList;

/**
 * Base command class.
 */
public abstract class Command {
    Game game;
    String name;
    ArrayList<String> synonyms;

    public Command(Game game, String name, ArrayList<String> synonyms) {
        this.game = game;
        this.name = name;
        this.synonyms = synonyms;
    }

    public Command(Game game, String name) {
        this.game = game;
        this.name = name;
        synonyms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void addSynonym(String synonym) {
        synonyms.add(synonym);
    }

    public boolean containsSynonym(String synonym) {
        return synonyms.contains(synonym);
    }
}
