package CaveExplorer;

import CaveExplorer.exceptions.GameErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

/**
 * Runs the game.
 */
public class CaveExplorer {

    //1.5 use of static keyword
    public static Game game;

    public static void main(String[] args) throws IOException {
        String input;
        String output = "";
        BufferedReader inputReader  = new BufferedReader(new InputStreamReader(System.in));
        boolean continueGame = true;

        game = new Game();
        game.showIntro(LocalTime.from(LocalDateTime.now()), new Locale.Builder().setLanguage("en").build());

        do {
            System.out.print("> ");
            input = inputReader.readLine();

            //6.1 Proper use of Try-Catch blocks
            try {
                output = Parser.parseUserInput(input);
            } catch (GameErrorException ex) {
                output = ex.getMessage();
            }

            System.out.println(output);

        } while (game.getContinueGame());
    }

    //Testing resource bundles for english/spanish game intro messages
    private static void testLocaleIntro() {
        LocalTime earlyMorning = LocalTime.of(5,35,16);
        LocalTime morning = LocalTime.of(8,55,55);
        LocalTime noon = LocalTime.of(12,22,56);
        LocalTime afternoon = LocalTime.of(16,5,0);
        LocalTime evening = LocalTime.of(22,11,27);

        Locale english = new Locale.Builder().setLanguage("en").build();
        Locale spanish = new Locale.Builder().setLanguage("es").build();

        //Early Morning Test
        System.out.print("Early Morning Intro English: ");
        game.showIntro(earlyMorning,english);
        System.out.print("Early Morning Intro Spanish: ");
        game.showIntro(earlyMorning,spanish);

        //Morning Test
        System.out.print("Morning Intro English: ");
        game.showIntro(morning,english);
        System.out.print("Morning Intro Spanish: ");
        game.showIntro(morning,spanish);

        //Noon Test
        System.out.print("Noon Intro English: ");
        game.showIntro(noon,english);
        System.out.print("Noon Intro Spanish: ");
        game.showIntro(noon,spanish);

        //Afternoon Test
        System.out.print("Afternoon Intro English: ");
        game.showIntro(afternoon,english);
        System.out.print("Afternoon Intro Spanish: ");
        game.showIntro(afternoon,spanish);

        //Evening Test
        System.out.print("Evening Intro English: ");
        game.showIntro(evening,english);
        System.out.print("Evening Intro Spanish: ");
        game.showIntro(evening,spanish);
    }
}
