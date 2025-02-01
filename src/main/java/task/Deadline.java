package task;

public class Deadline extends Task{
    protected String by;
    public Deadline(String name, String deadline) {
        super(name);
        this.by = deadline;
    }

    public Deadline(String name, String deadline, Boolean isCompleted) {
        super(name, isCompleted);
        this.by = deadline;
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
