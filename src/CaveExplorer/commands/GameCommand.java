package CaveExplorer.commands;

public interface GameCommand extends Command {
    String execute(String... parameters);
}
