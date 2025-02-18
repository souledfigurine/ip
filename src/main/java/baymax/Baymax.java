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
    private Ui ui;

    /**
     * Constructs a Baymax chatbot with a user interface, storage handler,
     * and task list. Loads existing tasks from storage if available.
     * If an error occurs during loading, it initializes with an empty task list.
     */
    public Baymax() {
        ui = new Ui();
        storage = new Storage();

        try {
            tasks = storage.loadTasks();
            if (tasks == null) {
                tasks = new TaskList();
            }
        } catch (Exception e) {
            ui.printError("Error loading tasks. Starting with an empty list.");
            tasks = new TaskList();
        }
    }

    /**
     * Runs the chatbot by continuously reading and executing user commands
     * until the user issues an exit command.
     */
    public void run() {
        ui.printGreeting();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = ui.readCommand();
                Command command = Parser.parse(userInput);
                if (command == null) {
                    ui.printError("Invalid command. Please try again.");
                    continue;
                }
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (IllegalArgumentException e) {
                ui.printError("Invalid command. Please try again.");
            }
        }
        ui.closeScanner();
    }

    /**
     * The main entry point of the program.
     * Initializes and runs the Baymax chatbot.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Baymax().run();
    }
}
