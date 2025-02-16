package command;

public abstract class AddCommand extends Command {
    protected final String taskName;
    public AddCommand(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
