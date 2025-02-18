package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks);
    }
}
