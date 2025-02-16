package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import task.Task;

public class DeleteCommand extends Command {
    private final int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.delete(taskNumber);
            storage.saveTasks(tasks);
            ui.printDeleteTask(taskNumber);
        } catch (IndexOutOfBoundsException e) {
            ui.printError(e.getMessage());
        }

    }
}
