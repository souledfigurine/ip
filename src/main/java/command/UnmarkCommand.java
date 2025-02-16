package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class UnmarkCommand extends Command {
    int taskNumber;

    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
