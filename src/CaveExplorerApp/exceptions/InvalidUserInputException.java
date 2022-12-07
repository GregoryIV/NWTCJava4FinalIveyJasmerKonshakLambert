package CaveExplorerApp.exceptions;

/**
 * Exceptions with user input
 */
public class InvalidUserInputException extends GameErrorException {
    public InvalidUserInputException(String errorMessage) {
        super(errorMessage);
    }
}