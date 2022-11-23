package CaveExplorer;

import java.util.ArrayList;

public class CommandList extends ArrayList<Command> {
    public Command findCommand(String command){
        for (Command c: this) {
            if (c.getName().equals(command) || c.containsSynonym(command)) {
                return c;
            }
        }

        return null;
    }

}
