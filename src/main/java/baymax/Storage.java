package baymax;

import java.io.*;
import java.util.ArrayList;
import task.*;

public class Storage {
    private static final String FILE_PATH = "./data/duke.txt";
    private File file;
    private File directory;
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

    public void saveTasks(TaskList tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) { // Overwrites file
            for (Task task : tasks.getTasks()) {
                writer.write(task.toString()); // Writes each task to file
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

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
                tasks.addTask(task);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    public static Task parseTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            Boolean isCompleted = parts[1].equals("true");

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
