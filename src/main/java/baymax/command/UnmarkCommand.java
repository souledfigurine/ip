package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import baymax.task.Task;

public class UnmarkCommand extends Command {
    int taskNumber;

    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.unmark(taskNumber);
        storage.saveTasks(tasks);
        ui.printUnmark(task);
    }
}
