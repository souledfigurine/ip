package baymax.command;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import baymax.task.Task;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;
    private ArrayList<Task> matchingList;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList matchingList = tasks.findTasks(keyword);
        ui.printMatchingList(matchingList);
    }
}
