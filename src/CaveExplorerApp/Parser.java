package CaveExplorerApp;

import CaveExplorerApp.commands.CommandFactory;
import CaveExplorerApp.commands.GameCommand;
import CaveExplorerApp.exceptions.GameCommandErrorException;
import CaveExplorerApp.exceptions.InvalidUserInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Converts user input into game commands.
 * Runs the game commands and returns relevant game knowledge to the user.
 */
public class Parser {
    private static CommandFactory commandFactory = new CommandFactory(CaveExplorer.game);

    /**
     *  Converts the user input into commands for the game.
     *
     * @param userInput - input provided by the user.
     * @return - Message back to the user
     */
    public static String parseUserInput(String userInput) throws InvalidUserInputException, GameCommandErrorException {
        String userMessage = "";

        ArrayList<String> userCommands = sanitizeUserInput(userInput);

        if (userCommands.size() == 0) {
            throw new InvalidUserInputException("You must write a command!");
        }

        if (userCommands.size() > 3) {
            throw new InvalidUserInputException("That command has too many words!");
        }

        try {
            userMessage = processUserCommand(userCommands);
        } catch (InvalidUserInputException ex) {
            throw ex;
        } catch (GameCommandErrorException ex) {
            throw ex;
        }

        return userMessage;
    }

    /**
     * Sanitize the user input into a more friendly format.
     * (lowercase, remove prepositions, splits into list)
     *
     * @param userInput - String of commands
     * @return - ArrayList of word(s)
     */
    private static ArrayList<String> sanitizeUserInput(String userInput) {
        String[] sanitizedInput = userInput.toLowerCase().split("\\s+");
        ArrayList<String> userCommands = new ArrayList<>();

        for (String command : sanitizedInput) {
            if (command.length() > 0) {
                userCommands.add(command);
            }
        }

        removePrepositions(userCommands);

        return userCommands;

    }

    /**
     * Removes prepositions from the list of user commands.
     *
     * @param userCommands - List of commands provided by the user
     */
    private static void removePrepositions(ArrayList<String> userCommands) {
        List<String> prepositions = Arrays.asList("on","in");

        userCommands.removeAll(prepositions);
    }

    /**
     * Takes user commands and converts them into game commands.
     * Executes any game commands found.
     *
     * @param userCommands - List of commands provided by the user
     * @return
     */
    private static String processUserCommand(ArrayList<String> userCommands) throws InvalidUserInputException, GameCommandErrorException {

        GameCommand gameCommand;
        String msg = "";
        String[] parameters = ((userCommands.size()>1) ? userCommands.subList(1, userCommands.size()).toArray(new String[0]) : null);

        gameCommand = commandFactory.getCommand(userCommands.get(0));

        if (gameCommand == null) {
            throw new InvalidUserInputException("Can't do this because '" + userCommands.get(0) + "' is not a command!");
        }

        try {
            msg = gameCommand.execute(parameters);
        } catch (GameCommandErrorException ex){
            throw ex;
        }

        return msg;
    }

}
