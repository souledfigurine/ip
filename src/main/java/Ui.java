import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public static void printNewTask(Task newTask) {
        System.out.println("______________________________________________________________\n"
                + "added: " + newTask + "\n"
                + "______________________________________________________________\n");
    }
    public static void printNewDeadline(Deadline newTask) {
        System.out.println("______________________________________________________________\n"
                + "added: " + newTask + "\n"
                + "______________________________________________________________\n");
    }

    public static void printNewEvent(Event newTask) {
        System.out.println("______________________________________________________________\n"
                + "added: " + newTask + "\n"
                + "______________________________________________________________\n");
    }

    public static void printMarkAsDone(Task task) {
        System.out.println("______________________________________________________________");
        System.out.println("Good job on completing the task!\n" + task);
        System.out.println("______________________________________________________________");
    }

    public static void printUnmark(Task task) {
        System.out.println("______________________________________________________________");
        System.out.println("I have unmarked the task for you!\n" + task);
        System.out.println("______________________________________________________________");
    }

    public static void printDeleteTask(Task taskToDelete) {
        System.out.println("______________________________________________________________");
        System.out.println("yay! 1 less task for you!\n"
                + taskToDelete );
        System.out.println("______________________________________________________________");
    }

    public void printGreeting() {
        String line = "______________________________________________________________\n";
        System.out.println(line
                + "Hello! I'm Baymax, your personal emotional companion :)\n"
                + "How may I help you today?\n"
                + line);
    }


    public String readCommand(String input) {
        return scanner.nextLine();
    }



}
