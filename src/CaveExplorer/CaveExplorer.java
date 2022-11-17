package CaveExplorer;

import java.io.*;
import java.time.LocalTime;
import java.util.Locale;

public class CaveExplorer {
    static Game game;

    public static void main(String[] args) throws IOException {
        String input;
        String output = "";
        BufferedReader inputReader  = new BufferedReader(new InputStreamReader(System.in));
        boolean continueGame = true;

        game = new Game();
        //testLocaleIntro();

        do {
            System.out.print("> ");
            input = inputReader.readLine();

            output = Parser.parseUserInput(input);

            System.out.println(output);

            //continueGame = false;
        } while (continueGame);
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
