package command;

public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand(int taskIndex){
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() {
        return null
    }
}
