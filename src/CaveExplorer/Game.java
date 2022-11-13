package CaveExplorer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Game {

    //Displays the game's introduction based on time and locale
    public void showIntro (LocalTime time, Locale locale) {
        String introMessage = "";
        ResourceBundle rb = ResourceBundle.getBundle("CaveExplorer", locale);

        if (time.isAfter(Times.earlyMorningBeg) && time.isBefore(Times.earlyMorningEnd)) {
            introMessage = rb.getString("intro_early_morning");
        } else if (time.isAfter(Times.morningBeg) && time.isBefore(Times.morningEnd)) {
            introMessage = rb.getString("intro_morning");
        } else if (time.isAfter(Times.noonBeg) && time.isBefore(Times.noonEnd)) {
            introMessage = rb.getString("intro_noon");
        } else if (time.isAfter(Times.afternoonBeg) && time.isBefore(Times.afternoonEnd)) {
            introMessage = rb.getString("intro_afternoon");
        } else if (time.isAfter(Times.eveningBeg) && time.isBefore(Times.eveningEnd)) {
            introMessage = rb.getString("intro_evening");
        }

        System.out.println(introMessage);
    }
}
