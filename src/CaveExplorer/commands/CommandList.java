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

    public String getCommandList() {
        StringBuilder returnString = new StringBuilder();

        this.forEach(command -> returnString.append(command.getName() + "\n"));

        return returnString.toString().trim();

    }

    public String getCommandDetails(String command) {
        StringBuilder returnString = new StringBuilder();
        CommandWithParameter c;

        c = this.findCommandWithParameter(command);
        if (c == null) {
            returnString.append("Command " + command + " does not exist.");
        } else {
            returnString.append(c.getName());
        }

        return returnString.toString();
    }

}
