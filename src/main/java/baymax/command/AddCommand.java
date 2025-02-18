package baymax.command;

/**
 * Represents an abstract command for adding tasks in the Baymax chatbot.
 * This class serves as a base for specific commands that add different types of tasks
 * (e.g., to-do, deadline, and event tasks).
 */
public abstract class AddCommand extends Command {
    protected final String taskName;

    /**
     * Constructs an {@code AddCommand} with the specified task name.
     *
     * @param taskName The name of the task to be added.
     */
    public AddCommand(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Returns whether this command signals an exit from the program.
     * Since add commands do not exit the program, this method always returns {@code false}.
     *
     * @return {@code false}, as add commands do not terminate the chatbot.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
