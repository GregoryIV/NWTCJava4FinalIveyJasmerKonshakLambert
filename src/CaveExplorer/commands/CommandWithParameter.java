package CaveExplorer.commands;

import CaveExplorer.commands.Command;

public interface CommandWithParameter extends Command {
    String execute(String... parameters);
}
