package Task;

public abstract class Task {
    protected String Name;
    protected Boolean isCompleted;
    public Task(String name) {
        this.Name = name;
        this.isCompleted = false;
    }
    public void markAsDone() {
        this.isCompleted = true;
    }
    public void unmarkAsDone() {
        this.isCompleted = false;
    }
    public String getStatusIcon() {
        return (isCompleted ? "[X]" : "[ ]");
    }
    @Override
    public String toString() {
        return getStatusIcon() + " " + Name;
    }
}
