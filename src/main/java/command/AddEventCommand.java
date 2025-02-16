package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;

public class AddEventCommand extends AddCommand {
    private final String from;
    private final String to;

    public AddEventCommand(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
