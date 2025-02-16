package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import task.Event;

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
        Event newTask = new Event(taskName, from, to);
        tasks.addTask(newTask);
        storage.saveTasks(tasks);
        ui.printNewEvent(newTask);
    }
}
