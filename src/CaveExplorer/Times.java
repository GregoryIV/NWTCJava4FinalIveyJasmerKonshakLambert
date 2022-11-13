package CaveExplorer;

import java.time.LocalTime;

public class Times {
    public static LocalTime earlyMorningBeg = LocalTime.of(0,0,0);
    public static LocalTime earlyMorningEnd = LocalTime.of(6,0,0);

    public static LocalTime morningBeg = LocalTime.of(6,1,0);
    public static LocalTime morningEnd = LocalTime.of(11,59,0);

    public static LocalTime noonBeg = LocalTime.of(12,0,0);
    public static LocalTime noonEnd = LocalTime.of(12,59,0);

    public static LocalTime afternoonBeg = LocalTime.of(13,0,0);
    public static LocalTime afternoonEnd = LocalTime.of(20,59,0);

    public static LocalTime eveningBeg = LocalTime.of(21,0,0);
    public static LocalTime eveningEnd = LocalTime.of(23,59,0);

}
