import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) return null;

        int day = dateTime.getDayOfMonth();
        String month = dateTime.getMonth().getDisplayName(java.time.format.TextStyle.FULL, Locale.FRENCH);

        int year = dateTime.getYear();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();

        return String.format("Le %d %s de l'an %d à %dh%dm et %ds",
                day, month, year, hour, minute, second);
    }
    public static String formatSimple(LocalDate date) {
        if (date == null) return null;
        String month = date.getMonth().getDisplayName(java.time.format.TextStyle.FULL, Locale.ITALIAN);
        int day = date.getDayOfMonth();

        int year = date.getYear() % 100;

        return String.format("%s %d %02d", month, day, year);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnn");
        return time.format(formatter);
    }
}
