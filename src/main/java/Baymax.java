import java.util.Scanner;
public class Baymax {
    //Create List to store inputs
    private String[] List = new String[100];
    private Boolean[] Completed = new Boolean[100];
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
        List[listCounter] = task;
        Completed[listCounter] = false;
        listCounter++;
        System.out.println("______________________________________________________________\n"
                + "added: "
                + task
                + "\n"
                + "______________________________________________________________\n");
    }

    private void printList() {
        System.out.println("______________________________________________________________");
        for (int i = 0; i < listCounter; i++) {
            int taskNumber = i + 1;
            if (Completed[i]) {
                System.out.println("[x] " + taskNumber + ". " + List[i]);
            } else {
                System.out.println("[ ] " + taskNumber + ". " + List[i]);
            }
        }
        System.out.println("______________________________________________________________");
    }

    private void markAsDone(int taskNumber) {
        Completed[taskNumber - 1] = true;
        System.out.println("______________________________________________________________");
        System.out.println("Good job on completing the task!\n"
                        + "  [X] " + List[taskNumber - 1] );
        System.out.println("______________________________________________________________");
    }

    private void unmark(int taskNumber) {
        if (!Completed[taskNumber - 1]) {
            System.out.println("it's ok! the task is still there");
        } else {
            Completed[taskNumber - 1] = false;
            System.out.println("______________________________________________________________");
            System.out.println("I have unmarked the task for you!\n"
                    + "  [ ] " + List[taskNumber - 1] );
            System.out.println("______________________________________________________________");
        }

    }
}
