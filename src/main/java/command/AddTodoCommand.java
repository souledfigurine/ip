package command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import task.Todo;

public class AddTodoCommand extends AddCommand {
    public AddTodoCommand(String taskName) {
        super(taskName);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo newTask = new Todo(this.taskName);
        tasks.addTask(newTask);
        storage.saveTasks(tasks);
        ui.printNewTodo(newTask);
    }
}
