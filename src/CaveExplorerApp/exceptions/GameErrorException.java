package CaveExplorerApp.exceptions;

/**
 * Base exception class for all exceptions in the game.
 */
public class GameErrorException extends Exception{
    public GameErrorException(String errorMessage) {
        super(errorMessage);
    }
}
