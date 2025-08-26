import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DifferenceBetweenDate {

    public static class Duration {
        private final java.time.Duration duration;

        public Duration(java.time.Duration duration) {
            this.duration = duration;
        }

        public long toHoursPart() {
            return duration.toHours() % 24;
        }

        public int toMinutesPart() {
            return duration.toMinutesPart();
        }

        public int toSecondsPart() {
            return duration.toSecondsPart();
        }
    }

    public static class Period {
        private final java.time.Period period;

        public Period(java.time.Period period) {
            this.period = period;
        }

        public int getYears() {
            return period.getYears();
        }

        public int getMonths() {
            return period.getMonths();
        }

        public int getDays() {
            return period.getDays();
        }
    }

    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        return new Duration(java.time.Duration.between(localTime1, localTime2).abs());
    }

    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        java.time.Period p = date1.isAfter(date2)
                ? java.time.Period.between(date2, date1)
                : java.time.Period.between(date1, date2);
        return new Period(p);
    }

    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        return Math.abs(ChronoUnit.HOURS.between(dateTime1, dateTime2));
    }
}
