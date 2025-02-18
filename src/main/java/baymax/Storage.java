package baymax;

import java.io.*;

import baymax.task.*;

/**
 * Handles the loading and saving of tasks to a storage file.
 * This class is responsible for reading and writing tasks to a file
 * to maintain persistence between program runs.
 */
public class Storage {
    private static final String FILE_PATH = "./data/duke.txt";
    private File file;
    private File directory;

    /**
     * Constructs a {@code Storage} object and initializes the storage file.
     * If the required directory does not exist, it creates the directory.
     * If the storage file does not exist, it creates a new file.
     */
    public Storage() {
        file = new File(FILE_PATH);
        directory = file.getParentFile();

        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating storage file: " + e.getMessage());
        }
    }

    /**
     * Saves the current list of tasks to the storage file.
     * The file is overwritten each time this method is called.
     *
     * @param tasks The {@code TaskList} containing tasks to be saved.
     */
    public void saveTasks(TaskList tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) { // Overwrites file
            for (Task task : tasks.getTasks()) {
                writer.write(task.toFileString()); // Writes each task to file
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    /**
     * Loads tasks from the storage file.
     * If the file does not exist, returns an empty {@code TaskList}.
     *
     * @return A {@code TaskList} containing the tasks loaded from the file.
     */
    public TaskList loadTasks() {
        File file = new File(FILE_PATH);
        TaskList tasks = new TaskList();

        if (!file.exists()) {
            return tasks;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                if (task != null) {
                    tasks.addTask(task);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Parses a line from the storage file into a {@code Task} object.
     * If the line is corrupted or unrecognized, it returns {@code null}.
     *
     * @param line The line from the file representing a stored task.
     * @return A {@code Task} object if successfully parsed, {@code null} otherwise.
     */
    public static Task parseTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isCompleted = parts[1].equals("true");

            switch (type) {
            case "T":
                return new Todo(parts[2], isCompleted);
            case "D":
                return new Deadline(parts[2], parts[3], isCompleted);
            case "E":
                return new Event(parts[2], parts[3], parts[4], isCompleted);
            default:
                return null;
            }
        } catch (Exception e) {
            System.out.println("Skipping corrupted task: " + line);
            return null;
        }
    }
}
