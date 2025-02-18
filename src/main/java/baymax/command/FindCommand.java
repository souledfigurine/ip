package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import baymax.task.Task;

import java.util.ArrayList;

/**
 * Represents a command that searches for tasks containing a specific keyword in their name.
 * The search is case-insensitive and returns a list of matching tasks.
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Constructs a {@code FindCommand} with the specified keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching for tasks that contain the keyword
     * and displaying the results to the user.
     *
     * @param tasks   The task list to search through.
     * @param ui      The UI component used to display messages.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList matchingList = tasks.findTasks(keyword);
        ui.printMatchingList(matchingList);
    }
}
