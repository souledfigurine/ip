package baymax.task;

public abstract class Task {
    protected String name;
    protected Boolean isCompleted;
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
    public Task(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }
    public void markAsCompleted() {
        this.isCompleted = true;
    }
    public void unmarkAsCompleted() {
        this.isCompleted = false;
    }
    public String getStatusIcon() {
        return (isCompleted ? "[X]" : "[ ]");
    }
    @Override
    public String toString() {
        return getStatusIcon() + " " + this.name;
    }

    public String toFileString() {
        return " | " + isCompleted + " | " + this.name;
    }
}
