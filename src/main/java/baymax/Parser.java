package baymax;

import baymax.command.*;

/**
 * Parses user input and returns the corresponding {@code Command} object.
 * The {@code Parser} class is responsible for analyzing user input and
 * determining the appropriate action to be executed.
 */
public class Parser {

    /**
     * Parses the user input and returns a {@code Command} object corresponding to the input command.
     *
     * @param input The full command entered by the user.
     * @return A {@code Command} object that corresponds to the user input.
     */
    public static Command parse(String input) {
        assert (input != null && !input.trim().isEmpty()) : "Command input should not be null or empty";

        String commandWord = input.split(" ")[0];
        String[] parts;
        int taskNumber;

        switch (commandWord) {
        case "list":
            return new ListCommand();
        case "mark":
            taskNumber = Integer.parseInt(input.split(" ")[1]);
            assert (taskNumber > 0) : "Task number must be positive for marking";
            return new MarkCommand(taskNumber);
        case "unmark":
            taskNumber = Integer.parseInt(input.split(" ")[1]);
            assert (taskNumber > 0) : "Task number must be positive for marking";
            return new UnmarkCommand(taskNumber);
        case "todo":
            return new AddTodoCommand(input.substring(5));
        case "deadline":
            parts = input.substring(9).split(" /by ");
            return new AddDeadlineCommand(parts[0], parts[1]);
        case "event":
            parts = input.substring(6).split(" /from ");
            String[] timeParts = parts[1].split(" /to ");
            return new AddEventCommand(parts[0], timeParts[0], timeParts[1]);
        case "delete":
            taskNumber = Integer.parseInt(input.split(" ")[1]);
            return new DeleteCommand(taskNumber);
        case "find":
            return new FindCommand(input.substring(5));
        default:
            return new ErrorCommand("Wrong input");
        }
    }
}
