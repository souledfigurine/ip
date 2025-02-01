import java.io.*;
import java.util.ArrayList;
import task.*;

public class Storage {
    private static final String FILE_PATH = "./data/duke.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        File file = new File(FILE_PATH);
        File directory = file.getParentFile();

        try {
            if (directory != null && !directory.exists()) {
                directory.mkdirs();
            }
            //Write tasks to file
            FileWriter writer = new FileWriter(file);
            for (Task task : tasks) {
                writer.write(task.toFileString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        File file = new File(FILE_PATH);
        ArrayList<Task> tasks = new ArrayList<Task>();

        if (!file.exists()) {
            return tasks;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                tasks.add(task);
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
