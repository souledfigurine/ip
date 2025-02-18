package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class ErrorCommand extends Command {
    private final String errorMessage;
    public ErrorCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printError(errorMessage);
    }
}
