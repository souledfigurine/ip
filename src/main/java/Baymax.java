import java.util.Scanner;
public class Baymax {
    public static void main(String[] args) {

        //Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        //Display greeting
        String line = "______________________________________________________________\n";
        System.out.println(line
                + "Hello! I'm Baymax, your personal emotional companion :)\n"
                + "How may I help you today?\n"
                + line);

        //Display exit message
        System.out.println(line
                + "Goodbye. Have a nice day, and remember;\n"
                + "don't forget to smell the flowers, as you aim for the sky\n"
                + line);

        //close scanner
        scanner.close();
    }
}
