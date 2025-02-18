package baymax;

import baymax.task.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks;

    /**
     * Generates a new empty baymax.task list
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
     * Adds a baymax.task to the list of baymax.task
     * @param task The new baymax.task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks a baymax.task as completed
     * @param taskNumber The number assigned to the baymax.task in the baymax.task list
     */
    public Task markAsDone(int taskNumber) {
        Task task = tasks.get(taskNumber - 1);
        task.markAsCompleted();
        return task;
    }

    /**
     * Unmarks a completed baymax.task as uncompleted
     * @param taskNumber The number assigned to the baymax.task in the baymax.task list
     */
    public Task unmark(int taskNumber) {
        Task task = tasks.get(taskNumber - 1);
        task.unmarkAsCompleted();
        return task;
    }

    /**
     * Deletes a baymax.task from the baymax.task list
     * @param taskNumber The number assigned to the baymax.task in the baymax.task list
     */
    public void delete(int taskNumber) throws IndexOutOfBoundsException {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid baymax.task number! Please enter a valid index.");
        }
        tasks.remove(taskNumber - 1);
    }
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
    public Boolean isEmpty() {
        return tasks.isEmpty();
    }
}
