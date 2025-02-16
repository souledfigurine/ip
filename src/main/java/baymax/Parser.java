package baymax;

import command.*;

public class Parser {
    public static Command parse(String input) {
        String commandWord = input.split(" ")[0];
        String[] parts;
        int taskNumber = Integer.parseInt(input.split(" ")[1]);

        switch (commandWord) {
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(taskNumber);
        case "unmark":
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
            return new DeleteCommand(taskNumber);
        default:
            return new ErrorCommand("Wrong input");
        }
    }
}
