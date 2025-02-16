package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime byDateTime;
    private LocalDate byDate;

    private static final DateTimeFormatter INPUT_FORMATTER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter INPUT_FORMATTER_2 = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");

    public Deadline(String name, String deadline) {
        super(name);
        parseDeadline(deadline);
    }

    public Deadline(String name, String deadline, boolean isCompleted) {
        super(name, isCompleted);
        parseDeadline(deadline);
    }

    private void parseDeadline(String deadline) {
        try {
            if (deadline.contains(" ")) {
                this.byDateTime = LocalDateTime.parse(deadline, INPUT_FORMATTER_2);
            } else {
                this.byDate = LocalDate.parse(deadline, INPUT_FORMATTER_1);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid deadline format! Use 'yyyy-MM-dd' or 'd/M/yyyy HHmm' (e.g., 2/12/2019 1800).");
        }
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
        return "D" + super.toFileString() + " | " + (byDateTime != null ? byDateTime.format(INPUT_FORMATTER_2) : byDate.format(INPUT_FORMATTER_1));
    }
}
