package baymax;

import task.Deadline;
import task.Event;
import task.Task;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    private static final String LINE = "______________________________________________________________";

    public Ui() {
        scanner = new Scanner(System.in);
    }
    public void printNewTodo(Task newTask) {
        System.out.print(LINE);
        System.out.println("added: " + newTask);
        System.out.print(LINE);
    }
    public void printNewDeadline(Deadline newTask) {
        System.out.print(LINE);
        System.out.println("added: " + newTask);
        System.out.print(LINE);
    }
    public void printNewEvent(Event newTask) {
        System.out.print(LINE);
        System.out.println("added: " + newTask);
        System.out.print(LINE);
    }
    public void printMarkAsDone(Task task) {
        System.out.println(LINE);
        System.out.println("Good job on completing the task!\n" + task);
        System.out.println(LINE);
    }
    public void printUnmark(Task task) {
        System.out.println(LINE);
        System.out.println("I have unmarked the task for you!\n" + task);
        System.out.println(LINE);
    }
    public void printDeleteTask(Task taskToDelete) {
        System.out.println(LINE);
        System.out.println("yay! 1 less task for you!");
        System.out.println(taskToDelete);
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
    public void printError(String ErrorMessage) {
        System.out.println(ErrorMessage);
    }
    public String readCommand() {
        return scanner.nextLine();
    }
}
