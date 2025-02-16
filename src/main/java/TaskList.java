import task.Deadline;
import task.Event;
import task.Todo;
import task.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks;

    /**
     * Generates a new empty task list
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }
    /**
     * Represents a list of tasks
     */
    public TaskList(ArrayList<Task> taskList) {
        this.tasks = taskList;
    }

    /**
     * Adds a task to the list of task
     * @param task The new task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks a task as completed
     * @param taskNumber The number assigned to the task in the task list
     */
    public void markAsDone(int taskNumber) {
        Task task = tasks.get(taskNumber - 1);
        task.markAsCompleted();
    }

    /**
     * Unmarks a completed task as uncompleted
     * @param taskNumber The number assigned to the task in the task list
     */
    public void unmark(int taskNumber) {
        Task task = tasks.get(taskNumber - 1);
        task.unmarkAsCompleted();
    }

    /**
     * Deletes a task from the task list
     * @param taskNumber The number assigned to the task in the task list
     */
    public void delete(int taskNumber) {
        tasks.remove(taskNumber - 1);
    }
}
