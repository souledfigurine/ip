package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class AddDeadlineCommand extends AddCommand{
    String by;
    public AddDeadlineCommand(String name, String by) {
        super(name);
        this.by = by;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
