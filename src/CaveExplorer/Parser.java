package CaveExplorer;

import CaveExplorer.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static CommandFactory commandFactory = new CommandFactory(CaveExplorer.game);

    /**
     *  Converts the user input into commands for the game.
     *
     * @param userInput - input provided by the user.
     * @return - Message back to the user
     */
    public static String parseUserInput(String userInput) {
        String userMessage = "";

        ArrayList<String> userCommands = sanitizeUserInput(userInput);

        if (userCommands.size() == 0) {
            userMessage = "You must write a command!";
        } else if (userCommands.size() > 3) {
            userMessage = "That command is too long!";
        } else {
            userMessage = processUserCommand(userCommands);
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
            userCommands.add(command);
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
    private static String processUserCommand(ArrayList<String> userCommands) {

        GameCommand gameCommand;
        String msg = "";
        String[] parameters = ((userCommands.size()>1) ? userCommands.subList(1, userCommands.size()).toArray(new String[0]) : null);

        gameCommand = commandFactory.getCommand(userCommands.get(0));

        if (gameCommand == null) {
            msg = "Can't do this because '" + userCommands.get(0) + "' is not a command!";
        } else {
            msg = gameCommand.execute(parameters);
        }

        return msg;
    }

}
