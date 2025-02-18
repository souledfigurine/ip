package baymax;

import baymax.task.Deadline;
import baymax.task.Event;
import baymax.task.Task;

import java.util.Scanner;

/**
 * Handles interactions with the user, including displaying messages
 * and reading user input.
 */
public class Ui {
    private Scanner scanner;
    private static final String LINE = "______________________________________________________________";

    /**
     * Constructs a new {@code Ui} object and initializes the scanner for reading user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prints a message when a new to-do task is added.
     *
     * @param newTask The newly added to-do task.
     */
    public void printNewTodo(Task newTask) {
        System.out.println(LINE);
        System.out.println("added: " + newTask);
        System.out.println(LINE);
    }

    /**
     * Prints a message when a new deadline task is added.
     *
     * @param newTask The newly added deadline task.
     */
    public void printNewDeadline(Deadline newTask) {
        System.out.println(LINE);
        System.out.println("added: " + newTask);
        System.out.println(LINE);
    }

    /**
     * Prints a message when a new event task is added.
     *
     * @param newTask The newly added event task.
     */
    public void printNewEvent(Event newTask) {
        System.out.println(LINE);
        System.out.println("added: " + newTask);
        System.out.println(LINE);
    }

    /**
     * Prints a message when a task is marked as completed.
     *
     * @param task The task that was marked as completed.
     */
    public void printMarkAsDone(Task task) {
        System.out.println(LINE);
        System.out.println("Good job on completing the task!\n" + task);
        System.out.println(LINE);
    }

    /**
     * Prints a message when a task is unmarked as completed.
     *
     * @param task The task that was unmarked.
     */
    public void printUnmark(Task task) {
        System.out.println(LINE);
        System.out.println("I have unmarked the task for you!\n" + task);
        System.out.println(LINE);
    }

    /**
     * Prints a message when a task is deleted.
     *
     * @param taskNumber The number of the deleted task.
     */
    public void printDeleteTask(int taskNumber) {
        System.out.println(LINE);
        System.out.println("Yay! One less task for you!");
        System.out.println("Deleted task number: " + taskNumber);
        System.out.println(LINE);
    }

    /**
     * Prints the greeting message when the program starts.
     */
    public void printGreeting() {
        System.out.println(LINE);
        System.out.println("Hello! I'm Baymax, your personal emotional companion :)");
        System.out.println("How may I help you today?");
        System.out.println(LINE);
    }

    /**
     * Prints the exit message when the program ends.
     */
    public void printExit() {
        System.out.println(LINE);
        System.out.println("Goodbye. Have a nice day, and remember:");
        System.out.println("Don't forget to smell the flowers as you aim for the sky.");
        System.out.println(LINE);
    }

    /**
     * Prints the list of tasks.
     * If the task list is empty, an error message is displayed instead.
     *
     * @param tasks The list of tasks to be printed.
     */
    public void printList(TaskList tasks) {
        if (tasks.isEmpty()) {
            printError("You are free! You currently have 0 tasks.");
            return;
        }
        generateList(tasks);
    }

    public void printMatchingList(TaskList matchingTasks) {
        if (matchingTasks.isEmpty()) {
            printError("oh man, it seems like there are no matching tasks");
        }
        generateList(matchingTasks);
    }

    public void generateList(TaskList tasks) {
        System.out.println(LINE);
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            int taskNumber = i + 1;
            System.out.println(taskNumber + ". " + tasks.getTasks().get(i));
        }
        System.out.println(LINE);
    }

    /**
     * Prints an error message to notify the user of an issue.
     *
     * @param errorMessage The error message to be printed.
     */
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Reads the next user command from the console.
     *
     * @return The user input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Closes the scanner to release system resources.
     */
    public void closeScanner() {
        scanner.close();
    }
}
