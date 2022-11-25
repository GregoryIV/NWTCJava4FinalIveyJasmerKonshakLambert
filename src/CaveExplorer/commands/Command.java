package CaveExplorer.commands;

import java.util.ArrayList;

public interface Command {
    String getName();
    ArrayList<String> getSynonyms();
    void addSynonym(String synonym);
    boolean containsSynonym(String synonym);
}
