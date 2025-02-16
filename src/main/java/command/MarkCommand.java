package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand(int taskIndex){
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
    }
}
