package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import task.Deadline;

public class AddDeadlineCommand extends AddCommand{
    String by;
    public AddDeadlineCommand(String name, String by) {
        super(name);
        this.by = by;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline newTask = new Deadline(taskName, by);
        tasks.addTask(newTask);
        storage.saveTasks(tasks);
        ui.printNewDeadline(newTask);
    }
}
