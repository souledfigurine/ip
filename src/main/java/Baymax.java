import java.util.PrimitiveIterator;
import java.util.Scanner;
import task.*;
public class Baymax {
    private Task[] taskList = new Task[100];
    private int listCounter = 0;
    public static void main(String[] args) {
        //instantiate Baymax
        Baymax baymax = new Baymax();

        //Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        String userInput;

        //Display greeting
        String line = "______________________________________________________________\n";
        System.out.println(line
                + "Hello! I'm Baymax, your personal emotional companion :)\n"
                + "How may I help you today?\n"
                + line);

        //Input loop
        while (true) {
            userInput = scanner.nextLine();

            //Check for end of conversation
            if (userInput.equalsIgnoreCase("bye")) {
                //Display exit message
                System.out.println(line
                        + "Goodbye. Have a nice day, and remember;\n"
                        + "don't forget to smell the flowers, as you aim for the sky\n"
                        + line);
                break;
            }
            //Check for list
            if (userInput.equalsIgnoreCase("list")) {
                baymax.printList();
                continue;
            }
            //mark task
            if (userInput.startsWith("mark")) {
                int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                baymax.markAsDone(taskNumber);
                continue;
            }
            //unmark task
            if (userInput.startsWith("unmark")) {
                int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                baymax.unmark(taskNumber);
                continue;
            }
            //add Todo
            if (userInput.startsWith("todo ")) {
                baymax.addTodo(userInput.substring(5));
                continue;
            }
            //add Deadline
            if (userInput.startsWith("deadline ")) {
                String[] parts = userInput.substring(9).split(" /by ");
                baymax.addDeadline(parts[0], parts[1]);
                continue;
            }
            //add Event
            if (userInput.startsWith("event ")) {
                String[] parts = userInput.substring(6).split(" /from ");
                String[] timeParts = parts[1].split(" /to ");
                baymax.addEvent(parts[0], timeParts[0], timeParts[1]);
                continue;
            }
            //delete Task
            if (userInput.startsWith("delete")) {
                int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                baymax.delete(taskNumber);
                continue;
            }

            System.out.println("Invalid command.");
        }

        //close scanner
        scanner.close();
    }
    //add Todo to taskList
    private void addTodo(String task) {
        Todo newTask = new Todo(task);
        taskList[listCounter] = newTask;
        listCounter++;
        System.out.println("______________________________________________________________\n"
                + "added: " + newTask + "\n"
                + "______________________________________________________________\n");
    }
    //add Deadline to taskList
    private void addDeadline(String task, String by) {
        Deadline newTask = new Deadline(task, by);
        taskList[listCounter] = newTask;
        listCounter++;
        System.out.println("______________________________________________________________\n"
                + "added: " + newTask + "\n"
                + "______________________________________________________________\n");
    }
    //add Event to taskList
    private void addEvent(String task, String from, String to) {
        Event newTask = new Event(task, from, to);
        taskList[listCounter] = newTask;
        listCounter++;
        System.out.println("______________________________________________________________\n"
                + "added: " + newTask + "\n"
                + "______________________________________________________________\n");
    }

    private void printList() {
        System.out.println("______________________________________________________________");
        for (int i = 0; i < listCounter; i++) {
            int taskNumber = i + 1;
            System.out.println(taskNumber + ". " + taskList[i]);
        }
        System.out.println("______________________________________________________________");
    }

    private void markAsDone(int taskNumber) {
        taskList[taskNumber - 1].markAsCompleted();
        System.out.println("______________________________________________________________");
        System.out.println("Good job on completing the task!\n"
                        + taskList[taskNumber - 1] );
        System.out.println("______________________________________________________________");
    }

    private void unmark(int taskNumber) {
        if (!taskList[taskNumber - 1].getIsCompleted()) {
            System.out.println("it's ok! the task is still there");
        } else {
            taskList[taskNumber - 1].unmarkAsCompleted();
            System.out.println("______________________________________________________________");
            System.out.println("I have unmarked the task for you!\n"
                    + taskList[taskNumber - 1] );
            System.out.println("______________________________________________________________");
        }
    }

    private void delete(int taskNumber) {
        if (taskNumber < 1 || taskNumber > listCounter) {
            System.out.println("______________________________________________________________");
            System.out.println("Invalid task number. Please enter a valid task number to delete.");
            System.out.println("______________________________________________________________");
            return;
        }
        Task taskToDelete = taskList[taskNumber - 1];

        for (int i = taskNumber - 1; i < listCounter; i++) {
            taskList[taskNumber - 1] = taskList[taskNumber];
        }
        taskList[listCounter] = null;
        listCounter--;
        System.out.println("______________________________________________________________");
        System.out.println("yay! 1 less task for you!\n"
                + taskToDelete );
        System.out.println("______________________________________________________________");
    }
}
