package baymax.command;

import baymax.TaskList;
import baymax.Storage;
import baymax.Ui;

/**
 * Represents an abstract command in the Baymax chatbot.
 * Commands are executed based on user input and can manipulate the task list,
 * interact with storage, and display output via the UI.
 */
public abstract class Command {
    protected boolean exit = false;

    /**
     * Executes the command, performing the necessary operations on the task list,
     * UI, and storage.
     *
     * @param tasks   The task list to be modified or accessed.
     * @param ui      The UI component to display messages to the user.
     * @param storage The storage handler to save or retrieve tasks.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    /**
     * Returns whether this command signals an exit from the program.
     *
     * @return {@code true} if the command is an exit command, {@code false} otherwise.
     */
    public boolean isExit() {
        return this.exit;
    }

    /**
     * Marks this command as an exit command, causing the chatbot to terminate after execution.
     */
    public void setExit() {
        this.exit = true;
    }
}
