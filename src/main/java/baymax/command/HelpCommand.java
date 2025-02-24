package baymax.command;

import java.io.IOException;

import baymax.Storage;
import baymax.TaskList;

/**
 * Represents a command that provides help information to users.
 * When executed, it returns a list of valid commands and their descriptions.
 */
public class HelpCommand extends Command {
    /**
     * A predefined help message listing all valid commands in the chatbot.
     */
    private static final String INVALID_INPUT = "oopsie idk watchu talking\n"
            + "make it make sense heresies thk uu\n"
            + "1. list - View all tasks\n"
            + "2. todo <task> - Add a to-do task\n"
            + "3. deadline <task> /by when - Add a deadline\n"
            + "4. event <task> /from when /to when - Add an event\n"
            + "5. mark <task number> - Mark a task as completed\n"
            + "6. unmark <task number> - Unmark a completed task\n"
            + "7. delete <task number> - Delete a task\n"
            + "8. find <keyword> - Search for tasks containing keyword\n";
    /**
     * * Executes the command, performing the necessary operations on the task list,
     * UI, and storage.
     *
     * @param tasks   The task list to be modified or accessed.
     * @param storage The storage handler to save or retrieve tasks.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws IOException {
        return INVALID_INPUT;
    }
}
