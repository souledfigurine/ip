package task;

public class Task {
    protected String Name;
    protected Boolean isCompleted;
    public Task(String name) {
        this.Name = name;
        this.isCompleted = false;
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
    public String getName() {
        return this.Name;
    }
    public Boolean getIsCompleted() {
        return this.isCompleted;
    }
    @Override
    public String toString() {
        return getStatusIcon() + " " + this.Name;
    }
}
