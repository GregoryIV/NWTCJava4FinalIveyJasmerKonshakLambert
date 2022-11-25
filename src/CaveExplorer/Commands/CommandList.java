package CaveExplorer.Commands;

import java.util.ArrayList;

public class CommandList extends ArrayList<Command> {
    public CaveExplorer.Command findCommand(String command){
        for (Command c: this) {
            if ((c.getName().equals(command) || c.containsSynonym(command))) {
                return (CaveExplorer.Command) c;
            }
        }

        return null;
    }

    public SingleCommand findSingleCommand(String command){
        for (Command c: this) {
            if (c instanceof SingleCommand & (c.getName().equals(command) || c.containsSynonym(command))) {
                return (SingleCommand) c;
            }
        }

        return null;
    }

    public CommandWithParameter findDoubleCommand(String command) {
        for (Command c: this) {
            if (c instanceof CommandWithParameter & (c.getName().equals(command) || c.containsSynonym(command))) {
                return (CommandWithParameter)c;
            }
        }

        return null;
    }

}
