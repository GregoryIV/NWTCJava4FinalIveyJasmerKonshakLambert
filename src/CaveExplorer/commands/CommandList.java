package CaveExplorer.commands;

import java.util.ArrayList;

public class CommandList extends ArrayList<Command> {
    public Command findCommand(String command){
        for (Command c: this) {
            if ((c.getName().equals(command) || c.containsSynonym(command))) {
                return (Command) c;
            }
        }

        return null;
    }

    public CommandWithParameter findCommandWithParameter(String command) {
        for (Command c: this) {
            if (c instanceof CommandWithParameter & (c.getName().equals(command) || c.containsSynonym(command))) {
                return (CommandWithParameter)c;
            }
        }

        return null;
    }

}
