package CaveExplorer;

import java.util.ArrayList;

public class SingleCommand extends Command{
    public SingleCommand(String name, String helpMessage) {
        super(name, helpMessage);
    }

    public SingleCommand(String name, ArrayList<String> synonyms, String helpMessage) {
        super(name,synonyms, helpMessage);
    }
}
