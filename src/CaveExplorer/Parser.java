package CaveExplorer;

import CaveExplorer.commands.*;

import java.util.ArrayList;
public class Parser {
    private static CommandList commandList = new CommandList();

    public static void initializeCommandList(Game game) {
        LookCommand lookCommand = new LookCommand(game,"look");
        MoveCommand moveCommand = new MoveCommand(game,"move");
        LookAtCommand lookAtCommand = new LookAtCommand(game,"look");
        TakeCommand takeCommand = new TakeCommand(game,"take");
        UseCommand useCommand = new UseCommand(game,"use");
        InventoryCommand inventoryCommand = new InventoryCommand(game,"inventory");
        DropCommand dropCommand = new DropCommand(game,"drop");

        moveCommand.addSynonym("walk");
        moveCommand.addSynonym("go");

        lookCommand.addSynonym("inspect");
        lookCommand.addSynonym("describe");
        lookCommand.addSynonym("investigate");

        takeCommand.addSynonym("grab");
        takeCommand.addSynonym("pickup");

        inventoryCommand.addSynonym("i");

        commandList.add(moveCommand);
        commandList.add(lookCommand);
        commandList.add(lookAtCommand);
        commandList.add(takeCommand);
        commandList.add(dropCommand);
        commandList.add(inventoryCommand);
        commandList.add(useCommand);
    }


    /**
     * TODO Go through double word commands and implement the correct methods
     *
     * @param commands
     * @return
     */
    private static String processCommandWithParameter(ArrayList<String> commands) {

        String commandName = commands.get(0);
        String commandParameter = commands.get(1);
        CommandWithParameter c;
        String msg = "";

        c = commandList.findCommandWithParameter(commandName);

        if (c == null) {
            if (commandList.findSingleCommand(commandName) == null) {
                msg = "Can't do this because '" + commandName + "' is not a command!";
            } else {
                msg = "Can't do this because the '" + commandName + "' command only needs one word!";
            }
        } else {
            msg = c.execute(commandParameter);

        }

        return msg;
    }

    /**
     * TODO Go through single word commands and implement the correct methods
     *
     * @param commands
     * @return
     */
    private static String processSingleCommand(ArrayList<String> commands) {

        SingleCommand c;
        String msg = "";

        c = commandList.findSingleCommand(commands.get(0));

        if (c == null) {
            if (commandList.findCommandWithParameter(commands.get(0)) == null) {
                msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
            } else {
                msg = "Can't do this because the '" + commands.get(0) + "' command needs two words!";
            }
        } else {
            msg = c.execute();
        }

        return msg;
    }

    public static String parseUserInput(String userinput) {
        String returnString = "";

        ArrayList<String> commands = sanitizeUserInput(userinput);

        if (commands.size() == 0) {
            returnString = "You must write a command!";
        } else if (commands.size() > 2) {
            returnString = "That command is too long!";
        } else {
            switch (commands.size()) {
                case 1:
                    returnString = processSingleCommand(commands);
                    break;
                case 2:
                    returnString = processCommandWithParameter(commands);
                    break;
                default:
                    returnString = "Unable to process command";
                    break;
            }
        }
        return returnString;
    }
    private static String processMove(String direction) {
        Direction d;
        String returnString = "";

        d = Direction.findByString(direction);

        if (d != null) {
            returnString = CaveExplorer.game.MovePlayer(d);
        } else {
            returnString = direction + " is not a direction to move.";
        }

        return returnString;
    }

    private static ArrayList<String> sanitizeUserInput(String userInput) {
        String[] sanitizedInput = userInput.toLowerCase().split("\\s+");
        ArrayList<String> commands = new ArrayList<>();

        for (String command : sanitizedInput) {
            commands.add(command);
        }
        return commands;

    }
}
