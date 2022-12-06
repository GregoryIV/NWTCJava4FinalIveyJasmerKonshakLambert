package CaveExplorer.exceptions;

public class GameCommandErrorException extends GameErrorException {
    public GameCommandErrorException(String errorMessage) {
        super(errorMessage);
    }
}