package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

/**
 * Represents a command that lists all tasks in the Baymax chatbot.
 * This command retrieves the current tasks from the task list and displays them to the user.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by displaying all tasks in the task list.
     * This command does not modify the task list or storage.
     *
     * @param tasks   The task list containing tasks to be displayed.
     * @param ui      The UI component used to display the task list.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks);
    }
}
