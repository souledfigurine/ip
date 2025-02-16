import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    private static final String LINE = "______________________________________________________________";

    public Ui() {
        scanner = new Scanner(System.in);
    }
    public static void printNewTask(Task newTask) {
        System.out.print(LINE);
        System.out.println("added: " + newTask);
        System.out.print(LINE);
    }
    public static void printNewDeadline(Deadline newTask) {
        System.out.print(LINE);
        System.out.println("added: " + newTask);
        System.out.print(LINE);
    }
    public static void printNewEvent(Event newTask) {
        System.out.print(LINE);
        System.out.println("added: " + newTask);
        System.out.print(LINE);
    }
    public static void printMarkAsDone(Task task) {
        System.out.println(LINE);
        System.out.println("Good job on completing the task!\n" + task);
        System.out.println(LINE);
    }
    public static void printUnmark(Task task) {
        System.out.println(LINE);
        System.out.println("I have unmarked the task for you!\n" + task);
        System.out.println(LINE);
    }
    public static void printDeleteTask(Task taskToDelete) {
        System.out.println(LINE);
        System.out.println("yay! 1 less task for you!")
        System.out.println(taskToDelete);
        System.out.println(LINE);
    }

    public void printGreeting() {
        System.out.println(LINE);
        System.out.println("Hello! I'm Baymax, your personal emotional companion :)");
        System.out.println("How may I help you today?");
        System.out.println(LINE);
    }


    public String readCommand(String input) {
        return scanner.nextLine();
    }
}
