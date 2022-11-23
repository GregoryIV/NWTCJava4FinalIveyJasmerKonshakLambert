package CaveExplorer;

import java.util.ArrayList;

/**
 * A command
 */
public class Command {
    private String name;
    private ArrayList<String> synonyms;

    private String helpMessage;

    public Command(String name, String helpMessage) {
        this.name = name;
        this.helpMessage = helpMessage;
        synonyms = new ArrayList<>();
    }

    public Command(String name, ArrayList<String> synonyms, String helpMessage) {
        this.name = name;
        this.synonyms = synonyms;
        this.helpMessage = helpMessage;
    }

    public String getName() {
        return name;
    }

    public boolean containsSynonym(String synonym) {
        return synonyms.contains(synonym);
    }

    public boolean removeSynonym (String synonym) {
        return synonyms.remove(synonym);
    }

    public void addSynonym(String synonym) {
        synonyms.add(synonym.toLowerCase());
    }

}
