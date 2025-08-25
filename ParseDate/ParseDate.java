import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;

        String[] parts = stringDate.split(",\\s*");

        String[] hourParts = parts[0].split(" ");
        int hour = Integer.parseInt(hourParts[0]);
        String period = hourParts[3];

        String[] minSecParts = parts[1].split(" ");
        int minute = Integer.parseInt(minSecParts[0]);
        int second = Integer.parseInt(minSecParts[3]);

        if (period.equals("soir") && hour != 12) {
            hour += 12;
        } else if (period.equals("matin") && hour == 12) {
            hour = 0;
        }

        return LocalTime.of(hour, minute, second);
    }
}
