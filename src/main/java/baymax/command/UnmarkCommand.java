package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import baymax.task.Task;

/**
 * Represents a command that marks a task as incomplete in the Baymax chatbot.
 * This command updates the task's status, saves the updated task list to storage,
 * and notifies the user.
 */
public class UnmarkCommand extends Command {
    private final int taskNumber;

    /**
     * Constructs an {@code UnmarkCommand} with the specified task number.
     *
     * @param taskNumber The index of the task to be marked as incomplete (1-based).
     */
    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Executes the unmark command by marking a task as incomplete,
     * saving the updated task list to storage, and notifying the user.
     *
     * @param tasks   The task list containing the task to be unmarked.
     * @param ui      The UI component used to display messages.
     * @param storage The storage handler to save the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.unmark(taskNumber);
        storage.saveTasks(tasks);
        ui.printUnmark(task);
    }
}

