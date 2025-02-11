package task;

import java.time.LocalDate;

public class Deadline extends Task{
    protected LocalDate by;
    public Deadline(String name, String deadline) {
        super(name);
        LocalDate time = LocalDate.parse(deadline);
        this.by = time;
    }

    public Deadline(String name, String deadline, Boolean isCompleted) {
        super(name, isCompleted);
        LocalDate time = LocalDate.parse(deadline);
        this.by = time;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFileString() {
        return "D" + super.toFileString() + " | " + by;
    }
}
