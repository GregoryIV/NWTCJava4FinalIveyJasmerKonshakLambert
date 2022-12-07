package CaveExplorerApp.exceptions;

/**
 * Exceptions in the games commands
 */
public class GameCommandErrorException extends GameErrorException {
    public GameCommandErrorException(String errorMessage) {
        super(errorMessage);
    }
}