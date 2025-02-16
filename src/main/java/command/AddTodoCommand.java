package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class AddTodoCommand extends AddCommand {
    public AddTodoCommand(String name) {
        super(name);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
    }
}
