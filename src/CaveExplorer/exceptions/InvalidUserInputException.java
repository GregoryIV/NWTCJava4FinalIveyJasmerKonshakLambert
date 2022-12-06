package CaveExplorer.exceptions;

public class InvalidUserInputException extends GameErrorException {
    public InvalidUserInputException(String errorMessage) {
        super(errorMessage);
    }
}