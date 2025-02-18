package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import baymax.task.Task;

public class MarkCommand extends Command {
    private int taskNumber;

    public MarkCommand(int taskIndex){
        this.taskNumber = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.markAsDone(taskNumber);
        storage.saveTasks(tasks);
        ui.printMarkAsDone(task);
    }
}
