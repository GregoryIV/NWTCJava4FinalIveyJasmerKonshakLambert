package CaveExplorer;

import java.util.ArrayList;

public class CommandList extends ArrayList<Command> {
    public Command findCommand(String command){
        for (Command c: this) {
            if ((c.getName().equals(command) || c.containsSynonym(command))) {
                return c;
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

    public DoubleCommand findDoubleCommand(String command) {
        for (Command c: this) {
            if (c instanceof DoubleCommand & (c.getName().equals(command) || c.containsSynonym(command))) {
                return (DoubleCommand)c;
            }
        }

        return null;
    }

}
