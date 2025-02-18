package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class ExitCommand extends Command{
    public ExitCommand() {
        this.exit = true;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printExit();
    }
}
