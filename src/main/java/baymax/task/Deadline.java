package baymax.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime byDateTime;
    private LocalDate byDate;

    private static final DateTimeFormatter INPUT_FORMATTER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter INPUT_FORMATTER_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");

    public Deadline(String name, String deadline, boolean isCompleted) {
        super(name, isCompleted);
        determineDeadlineType(deadline);
    }

    public Deadline(String name, String deadline) {
        super(name);
        determineDeadlineType(deadline);
    }

    private void determineDeadlineType(String deadline) {
        if (deadline.contains(" ")) {
            this.byDateTime = safelyParseDateTime(deadline);
        } else {
            this.byDate = safelyParseDate(deadline);
        }
    }

    private LocalDateTime safelyParseDateTime(String deadline) {
        try {
            return LocalDateTime.parse(deadline, INPUT_FORMATTER_2);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid datetime format! Use 'yyyy-MM-dd HHmm'.");
        }
    }

    private LocalDate safelyParseDate(String deadline) {
        try {
            return LocalDate.parse(deadline, INPUT_FORMATTER_1);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format! Use 'yyyy-MM-dd'.");
        }
    }

    private LocalDateTime parseDateTime(String deadline) throws DateTimeParseException {
        return LocalDateTime.parse(deadline, INPUT_FORMATTER_2);
    }

    private LocalDate parseDate(String deadline) throws DateTimeParseException {
        return LocalDate.parse(deadline, INPUT_FORMATTER_1);
    }

    private String formatDeadline() {
        if (byDateTime != null) return byDateTime.format(DISPLAY_FORMATTER);
        if (byDate != null) return byDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "Invalid date";
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatDeadline() + ")";
    }

    @Override
    public String toFileString() {
        if (byDateTime != null) {
            return "D" + super.toFileString() + " | " + byDateTime.format(INPUT_FORMATTER_2);
        }
        if (byDate != null) {
            return "D" + super.toFileString() + " | " + byDate.format(INPUT_FORMATTER_1);
        }
        return "D" + super.toFileString() + " | Invalid date";
    }

}
