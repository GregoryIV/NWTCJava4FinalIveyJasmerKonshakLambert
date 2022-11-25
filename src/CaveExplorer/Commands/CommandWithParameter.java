package CaveExplorer.Commands;

public interface CommandWithParameter extends Command{
    String execute(String parameter);
}
