
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        return LocalDate.parse(stringDate, java.time.format.DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", java.util.Locale.FRENCH));
    }

    public static LocalTime parseTimeFormat(String stringDate) {
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
