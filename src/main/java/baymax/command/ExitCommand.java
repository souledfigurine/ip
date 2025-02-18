package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

/**
 * Represents a command that signals the Baymax chatbot to terminate.
 * This command does not modify the task list or storage but informs the user of the exit.
 */
public class ExitCommand extends Command {

    /**
     * Constructs an {@code ExitCommand} that sets the chatbot's exit status to {@code true}.
     */
    public ExitCommand() {
        this.exit = true;
    }

    /**
     * Executes the exit command by displaying the exit message to the user.
     * This command does not modify the task list or storage.
     *
     * @param tasks   The task list (not used in this command).
     * @param ui      The UI component used to display the exit message.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printExit();
    }
}
