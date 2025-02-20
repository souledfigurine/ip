package baymax;

import baymax.command.Command;

/**
 * Represents the main chatbot application, Baymax.
 * Baymax is a task manager that processes user commands
 * and executes corresponding actions such as adding, listing,
 * marking, unmarking, and deleting tasks.
 */
public class Baymax {
    private Storage storage;
    private TaskList tasks;

    /**
     * Constructs a Baymax chatbot with a user interface, storage handler,
     * and task list. Loads existing tasks from storage if available.
     * If an error occurs during loading, it initializes with an empty task list.
     */
    public Baymax() {
        storage = new Storage();

        try {
            tasks = storage.loadTasks();
            if (tasks == null) {
                tasks = new TaskList();
            }
        } catch (Exception e) {
            tasks = new TaskList();
        }
    }

    /**
     * Processes user input and returns Baymax's response as a string.
     *
     * @param input The user's input command.
     * @return The chatbot's response as a formatted string.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            if (command == null) {
                return "Invalid command. Please try again.";
            }
            return command.execute(tasks, storage);
        } catch (IllegalArgumentException e) {
            return "Invalid command. Please try again.";
        }
    }
    /**
     * Returns Baymax's greeting message.
     *
     * @return A greeting message.
     */
    public String getGreeting() {
        return "Hello! I'm Baymax, your personal emotional companion :)\n"
                + "How may I help you today?";
    }
}
