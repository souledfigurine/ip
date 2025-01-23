import java.util.Scanner;
public class Baymax {
    public static void main(String[] args) {

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
            } else {
                //Echo userInput
                //Display exit message
                System.out.println(line
                        + userInput
                        + "\n"
                        + line);
            }
        }

        //close scanner
        scanner.close();
    }
}
