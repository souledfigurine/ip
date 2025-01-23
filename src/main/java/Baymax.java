import java.util.Scanner;
public class Baymax {
    //Create List to store inputs
    private String[] List = new String[100];
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
            //if (userInput.equalsIgnoreCase("list"))

            //add userInput into List
            baymax.addTask(userInput);

            //Display exit message
            System.out.println(line
                    + "added: "
                    + userInput
                    + "\n"
                    + line);

        }

        //close scanner
        scanner.close();
    }

    private void addTask(String task) {
        List[listCounter] = task;
        listCounter++;
    }
}
