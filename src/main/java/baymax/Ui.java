package baymax;

import baymax.task.Deadline;
import baymax.task.Event;
import baymax.task.Task;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    private static final String LINE = "______________________________________________________________";

    public Ui() {
        scanner = new Scanner(System.in);
    }
    public void printNewTodo(Task newTask) {
        System.out.println(LINE);
        System.out.println("added: " + newTask);
        System.out.println(LINE);
    }
    public void printNewDeadline(Deadline newTask) {
        System.out.println(LINE);
        System.out.println("added: " + newTask);
        System.out.println(LINE);
    }
    public void printNewEvent(Event newTask) {
        System.out.println(LINE);
        System.out.println("added: " + newTask);
        System.out.println(LINE);
    }
    public void printMarkAsDone(Task task) {
        System.out.println(LINE);
        System.out.println("Good job on completing the baymax.task!\n" + task);
        System.out.println(LINE);
    }
    public void printUnmark(Task task) {
        System.out.println(LINE);
        System.out.println("I have unmarked the baymax.task for you!\n" + task);
        System.out.println(LINE);
    }
    public void printDeleteTask(int taskNumber) {
        System.out.println(LINE);
        System.out.println("yay! 1 less baymax.task for you!");
        System.out.println("delete " + taskNumber);
        System.out.println(LINE);
    }

    public void printGreeting() {
        System.out.println(LINE);
        System.out.println("Hello! I'm baymax.Baymax, your personal emotional companion :)");
        System.out.println("How may I help you today?");
        System.out.println(LINE);
    }
    public void printExit() {
        System.out.println(LINE);
        System.out.println("Goodbye. Have a nice day, and remember:");
        System.out.println("don't forget to smell the flowers, as you aim for the sky");
        System.out.println(LINE);
    }
    public void printList(TaskList tasks) {
        if (tasks.isEmpty()) {
            printError("You are free! You currently have 0 tasks");
        }

        System.out.println(LINE);
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            int taskNumber = i + 1;
            System.out.println(taskNumber + ". " + tasks.getTasks().get(i));
        }
        System.out.println(LINE);
    }
    public void printError(String ErrorMessage) {
        System.out.println(ErrorMessage);
    }
    public String readCommand() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
