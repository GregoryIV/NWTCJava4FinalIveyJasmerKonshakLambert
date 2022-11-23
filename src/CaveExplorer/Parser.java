package CaveExplorer;

import java.util.ArrayList;
public class Parser {
    private static CommandList commandList = new CommandList();

    public static void initializeCommandList() {
        SingleCommand lookCommand = new SingleCommand("look","The look command describes the player's current location");
        DoubleCommand lookAtCommand = new DoubleCommand("look",
                "The look [object] command describes the object.\n" +
                           "[object] - Any given object within the players field of vision");
        DoubleCommand moveCommand = new DoubleCommand("move",
                "The move [direction] command moves the player in the given direction.\n" +
                            "[direction] - North/South/East/West");
        DoubleCommand takeCommand = new DoubleCommand("take","");
        DoubleCommand dropCommand = new DoubleCommand("drop","");
        SingleCommand inventoryCommand = new SingleCommand("inventory","");
        DoubleCommand useCommand = new DoubleCommand("use","");
        SingleCommand helpCommand = new SingleCommand("help",
                "The help command lists all available commands.");

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
        commandList.add(lookAtCommand);
        commandList.add(takeCommand);
        commandList.add(dropCommand);
        commandList.add(inventoryCommand);
        commandList.add(useCommand);
        commandList.add(helpCommand);
    }


    /**
     * TODO Go through double word commands and implement the correct methods
     *
     * @param commands
     * @return
     */
    private static String processDoubleCommand(ArrayList<String> commands) {
        String commandName = commands.get(0);
        String commandParameter = commands.get(1);
        DoubleCommand c;
        String msg = "";

        c = commandList.findDoubleCommand(commandName);

        if (c == null) {
            if (commandList.findSingleCommand(commandName) == null) {
                msg = "Can't do this because '" + commandName + "' is not a command!";
            } else {
                msg = "Can't do this because the '" + commandName + "' command only needs one word!";
            }
        } else {
            c.setParameter(commandParameter);

            switch (c.getName()) {
                case "move":
                    msg = processMove(c.getParameter());
                    break;
                case "look":
                    //TODO implement the look command
                    msg = CaveExplorer.game.playerLookAt(c.getParameter());
                    break;
                case "take":
                    //TODO implement the take command
                    break;
                case "drop":
                    //TODO implement the drop command
                    break;
                case "use":
                    //TODO implement the use command
                    break;
                default:
                    break;
            }
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
            if (commandList.findDoubleCommand(commands.get(0)) == null) {
                msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
            } else {
                msg = "Can't do this because the '" + commands.get(0) + "' command needs two words!";
            }
        } else {
            switch (c.getName()) {
                case "n":
                    break;
                case "s":
                    break;
                case "w":
                    break;
                case "e":
                    break;
                case "up":
                    break;
                case "down":
                    break;
                case "look":
                    msg = CaveExplorer.game.playerLook();
                    break;
                case "inventory":
                    msg = CaveExplorer.game.ShowPlayerInventory();
                    break;
                default:
                    break;
            }
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
                    returnString = processDoubleCommand(commands);
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
