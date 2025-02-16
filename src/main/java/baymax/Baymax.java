package baymax;

import java.util.Scanner;
import command.Command;
import task.*;

public class Baymax {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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

    public static void main(String[] args) {
        new Baymax().run();
    }
}