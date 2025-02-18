package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import baymax.task.Task;

/**
 * Represents a command that marks a task as completed in the Baymax chatbot.
 * This command updates the task's status, saves the updated task list to storage,
 * and notifies the user.
 */
public class MarkCommand extends Command {
    private final int taskNumber;

    /**
     * Constructs a {@code MarkCommand} with the specified task number.
     *
     * @param taskIndex The index of the task to be marked as completed (1-based index).
     */
    public MarkCommand(int taskIndex) {
        this.taskNumber = taskIndex;
    }

    /**
     * Executes the mark command by marking the task as completed,
     * saving the updated task list to storage, and notifying the user.
     *
     * @param tasks   The task list containing the task to be marked as completed.
     * @param ui      The UI component used to display confirmation messages.
     * @param storage The storage handler to save the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.markAsDone(taskNumber);
        storage.saveTasks(tasks);
        ui.printMarkAsDone(task);
    }
}
