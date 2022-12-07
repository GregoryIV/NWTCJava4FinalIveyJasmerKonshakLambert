package CaveExplorerApp;

import CaveExplorerApp.exceptions.GameErrorException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

/**
 * Runs the game.
 */
public class CaveExplorer {

    //1.5 use of static keyword
    public static Game game;

    /**
     * Main method to run the game.
     * @param args - Game arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String input;
        String output;
        BufferedReader inputReader  = new BufferedReader(new InputStreamReader(System.in));

        game = new Game();
        game.showIntro(LocalTime.from(LocalDateTime.now()), new Locale.Builder().setLanguage("en").build());

        do {
            System.out.print("> ");
            input = inputReader.readLine();

            //6.1 Proper use of Try-Catch blocks
            try {
                output = Parser.parseUserInput(input);
            } catch (GameErrorException ex) {
                appendToFile(ex);
                output = ex.getMessage();
            }

            System.out.println(output);

        } while (game.getContinueGame());
    }

    /**
     * Logging Method for writing exceptions to a log file
     * 8.2 Demonstration of file writer class
     * @param e The exception being logged
     */
    private static void appendToFile(Exception e) {
        try {
            FileWriter logFile = new FileWriter("Error-log.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(logFile);
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            e.printStackTrace(printWriter);
        }
        catch (Exception ie) {
            throw new RuntimeException("Cannot write the Exception to file", ie);
        }
    }
}
