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

    public GameCommand findCommandWithParameter(String command) {
        for (Command c: this) {
            if (c instanceof GameCommand & (c.getName().equals(command) || c.containsSynonym(command))) {
                return (GameCommand)c;
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
        GameCommand c;

        c = this.findCommandWithParameter(command);
        if (c == null) {
            returnString.append("Command " + command + " does not exist.");
        } else {
            returnString.append(c.getName());
        }

        return returnString.toString();
    }

}
