package CaveExplorer;

import CaveExplorer.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static CommandList commandList = new CommandList();

    public static void initializeCommandList(Game game) {
        LookCommand lookCommand = new LookCommand(game,"look");
        MoveCommand moveCommand = new MoveCommand(game,"move");
        TakeCommand takeCommand = new TakeCommand(game,"take");
        UseCommand useCommand = new UseCommand(game,"use");
        InventoryCommand inventoryCommand = new InventoryCommand(game,"inventory");
        DropCommand dropCommand = new DropCommand(game,"drop");
        HelpCommand helpCommand = new HelpCommand(game, "help");

        moveCommand.addSynonym("walk");
        moveCommand.addSynonym("go");

        lookCommand.addSynonym("inspect");
        lookCommand.addSynonym("describe");
        lookCommand.addSynonym("investigate");

        takeCommand.addSynonym("grab");
        takeCommand.addSynonym("pickup");

        inventoryCommand.addSynonym("i");

        helpCommand.addSynonym("?");

        commandList.add(moveCommand);
        commandList.add(lookCommand);
        commandList.add(takeCommand);
        commandList.add(dropCommand);
        commandList.add(inventoryCommand);
        commandList.add(useCommand);
        commandList.add(helpCommand);
    }

    private static String processCommand(ArrayList<String> commands) {

        CommandWithParameter c;
        String msg = "";
        String[] parameters = ((commands.size()>1) ? commands.subList(1, commands.size()).toArray(new String[0]) : null);

        c = commandList.findCommandWithParameter(commands.get(0));

        if (c == null) {
            msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
        } else {
            msg = c.execute(parameters);
        }

        return msg;
    }

    public static String parseUserInput(String userinput) {
        String returnString = "";

        ArrayList<String> commands = sanitizeUserInput(userinput);

        if (commands.size() == 0) {
            returnString = "You must write a command!";
        } else if (commands.size() > 3) {
            returnString = "That command is too long!";
        } else {
            returnString = processCommand(commands);
        }
        return returnString;
    }

    private static ArrayList<String> sanitizeUserInput(String userInput) {
        String[] sanitizedInput = userInput.toLowerCase().split("\\s+");
        ArrayList<String> commands = new ArrayList<>();

        for (String command : sanitizedInput) {
            commands.add(command);
        }

        removePrepositions(commands);

        return commands;

    }

    private static void removePrepositions(ArrayList<String> commands) {
        List<String> prepositions = Arrays.asList("on","in");

        commands.removeAll(prepositions);

    }
}
