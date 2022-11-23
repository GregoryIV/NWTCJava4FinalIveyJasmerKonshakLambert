package CaveExplorer;

import java.util.ArrayList;
public class Parser {
    private static CommandList commandList = new CommandList();

    public static void initializeCommandList() {
        Command lookCommand = new Command("look",1, 2);
        Command moveCommand = new Command("move",2, 2);
        Command takeCommand = new Command("take",2,2);
        Command dropCommand = new Command("drop",2,2);
        Command inventoryCommand = new Command("inventory",1,1);
        Command useCommand = new Command("use",2,2);

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
    private static String processDoubleCommand(ArrayList<String> commands) {
        Command c;
        String msg = "";

        c = commandList.findCommand(commands.get(0));

        if (c == null) {
            msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
        } else if (c.getWordCountMaximum() < 2 ) {
            msg = "Can't do this because the '" + commands.get(0) + "' command only needs " + c.getWordCountMaximum() + " word(s)!";
        } else {
            switch (c.getName()) {
                case "move":
                    msg = processMove(commands.get(1));
                    break;
                case "look":
                    //TODO implement the look command
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
        Command c;
        String msg = "";

        c = commandList.findCommand(commands.get(0));

        if (c == null) {
            msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
        } else if (c.getWordCountMinimum() > 1 ) {
            msg = "Can't do this because the '" + commands.get(0) + "' command needs " + c.getWordCountMinimum() + " words!";
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
                case "l":
                case "look":
                    break;
                case "inventory":
                case "i":
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
