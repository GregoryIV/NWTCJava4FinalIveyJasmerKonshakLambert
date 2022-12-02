package CaveExplorer.commands;

import CaveExplorer.Game;

public class CommandFactory {
    private static CommandList commandList = new CommandList();

    public CommandFactory(Game game) {
        LookCommand lookCommand = new LookCommand(game,"look");
        MoveCommand moveCommand = new MoveCommand(game,"move");
        TakeCommand takeCommand = new TakeCommand(game,"take");
        UseCommand useCommand = new UseCommand(game,"use");
        InventoryCommand inventoryCommand = new InventoryCommand(game,"inventory");
        DropCommand dropCommand = new DropCommand(game,"drop");
        HelpCommand helpCommand = new HelpCommand(game, "help", commandList);

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

    public GameCommand getCommand(String commandType) {
        if (commandType == null) {
            return null;
        } else {
            return commandList.findCommandWithParameter(commandType);
        }
    }
}
