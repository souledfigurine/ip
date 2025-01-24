import java.util.PrimitiveIterator;
import java.util.Scanner;
import task.*;
public class Baymax {
//    //Create List to store inputs
//    private String[] List = new String[100];
//    //Array to track whether task is completed
//    private Boolean[] Completed = new Boolean[100];
//    //Enum array to track if it is a To-do, deadline, or event
//    enum typesOfTasks {
//        T, D, E
//    }
    //Create List to store tasks
    private Task[] taskList = new Task[100];
//    private typesOfTasks[] Categories = new typesOfTasks[100];
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

            //add userInput into List
            baymax.addTask(userInput);
        }

        //close scanner
        scanner.close();
    }

    private void addTask(String task) {
//        if (task.startsWith("todo")) {
//            Categories[listCounter] = typesOfTasks.T;
//        } else if (task.startsWith("event")) {
//            Categories[listCounter] = typesOfTasks.E;
//        } else if (task.startsWith("deadline")) {
//            Categories[listCounter] = typesOfTasks.D;
//        } else {
//            System.out.println("______________________________________________________________\n"
//                    + "please add a category to the task!\n"
//                    + "______________________________________________________________\n");
//            return;
//        }
        Task newTask = new Task(task);
        taskList[listCounter] = newTask;
        listCounter++;
        System.out.println("______________________________________________________________\n"
                + "added: "
                + newTask.getName()
                + "\n"
                + "______________________________________________________________\n");
    }

    private void printList() {
        System.out.println("______________________________________________________________");
        for (int i = 0; i < listCounter; i++) {
            int taskNumber = i + 1;
            if (taskList[i].getIsCompleted()) {
                System.out.println("[x] " + taskNumber + ". " + taskList[i]);
            } else {
                System.out.println("[ ] " + taskNumber + ". " + taskList[i]);
            }
        }
        System.out.println("______________________________________________________________");
    }

    private void markAsDone(int taskNumber) {
        taskList[taskNumber - 1].markAsCompleted();
        System.out.println("______________________________________________________________");
        System.out.println("Good job on completing the task!\n"
                        + "  [X] " + taskList[taskNumber - 1] );
        System.out.println("______________________________________________________________");
    }

    private void unmark(int taskNumber) {
        if (!taskList[taskNumber - 1].getIsCompleted()) {
            System.out.println("it's ok! the task is still there");
        } else {
            taskList[taskNumber - 1].unmarkAsCompleted();
            System.out.println("______________________________________________________________");
            System.out.println("I have unmarked the task for you!\n"
                    + "  [ ] " + taskList[taskNumber - 1] );
            System.out.println("______________________________________________________________");
        }

    }
}
