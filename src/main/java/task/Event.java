package task;

public class Event extends Task {
    protected String from;
    protected String to;
    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, String from, String to, Boolean isCompleted) {
        super(name, isCompleted);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }

    @Override
    public String toFileString() {
        return "E" + super.toFileString() + " | " + this.from + " | " + this.to;
    }
}
