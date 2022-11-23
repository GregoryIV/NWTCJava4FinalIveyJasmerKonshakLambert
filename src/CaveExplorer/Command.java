package CaveExplorer;

import java.util.ArrayList;

/**
 * A command
 */
public class Command {
    private String name;
    private int wordCountMinimum;
    private int wordCountMaximum;
    private ArrayList<String> synonyms;

    public Command(String name, int wordCountMinimum, int wordCountMaximum) {
        this.name = name;
        this.wordCountMinimum = wordCountMinimum;
        this.wordCountMaximum = wordCountMaximum;
        synonyms = new ArrayList<>();
    }

    public Command(String name, int wordCountMinimum, int wordCountMaximum, ArrayList<String> synonyms) {
        this.name = name;
        this.wordCountMinimum = wordCountMinimum;
        this.wordCountMaximum = wordCountMaximum;
        this.synonyms = synonyms;
    }

    public String getName() {
        return name;
    }

    public int getWordCountMinimum() {
        return wordCountMinimum;
    }

    public int getWordCountMaximum() {
        return wordCountMaximum;
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
