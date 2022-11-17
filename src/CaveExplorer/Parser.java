package CaveExplorer;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    private static CommandList commandList = new CommandList();

    public static void initializeCommandList() {
        commandList.add(new Command("go",2,2));
        commandList.add(new Command("move",2, 2));
        commandList.add(new Command("look",1, 2));
        commandList.add(new Command("take",2, 2));
        commandList.add(new Command("inventory",1,1));
    }

    private static String processDoubleCommand(ArrayList<String> commands) {
        Command c;
        String msg = "";

        c = commandList.findCommand(commands.get(0));

        if (c.equals(null)) {
            msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
        } else if (c.getWordCountMaximum() < 2 ) {
            msg = "Can't do this because the '" + commands.get(0) + "' command only needs " + c.getWordCountMaximum() + " word(s)!";
        } else {
            switch (c.getName()) {
                case "move":
                    msg = processMove(commands.get(1));
                    break;
                default:
                    break;
            }
        }
        return msg;
    }

    private static String processSingleCommand(ArrayList<String> commands) {
        Command c;
        String msg = "";

        c = commandList.findCommand(commands.get(0));

        if (c.equals(null)) {
            msg = "Can't do this because '" + commands.get(0) + "' is not a command!";
        } else if (c.getWordCountMinimum() > 1 ) {
            msg = "Can't do this because the '" + commands.get(0) + "' needs " + c.getWordCountMinimum() + " words!";
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

        if (!d.equals(null)) {
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
