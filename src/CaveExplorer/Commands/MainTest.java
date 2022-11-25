package CaveExplorer.Commands;

import CaveExplorer.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {

    static Game game;

    public static void main(String[] args) throws IOException {
        game = new Game();

        CommandList commands = new CommandList();
        LookCommand lookCommand = new LookCommand(game,"look");
        MoveCommand moveCommand = new MoveCommand(game,"move");
        LookAtCommand lookAtCommand = new LookAtCommand(game,"look");
        moveCommand.addSynonym("walk");
        moveCommand.addSynonym("go");

        commands.add(moveCommand);
        commands.add(lookCommand);
        commands.add(lookAtCommand);

        String input;
        String output = "";
        BufferedReader inputReader  = new BufferedReader(new InputStreamReader(System.in));
        boolean continueGame = true;


        //testLocaleIntro();

        do {
            SingleCommand c;
            CommandWithParameter d;

            c = commands.findSingleCommand("look");

            System.out.println(c.execute());

            d = commands.findDoubleCommand("go");
            System.out.println(d.execute("north"));
            System.out.println(d.execute("west"));
            System.out.println(d.execute("east"));

            d = commands.findDoubleCommand("look");

            System.out.println(d.execute("flashlight"));
            System.out.println(d.execute("flashligh"));

            continueGame = false;
        } while (continueGame);
    }
}