package baymax;
import baymax.task.Task;

import baymax.task.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class UiTest {
    private Ui ui;
    private ByteArrayOutputStream outContent;
    private static final String LINE = "______________________________________________________________\n";

    @BeforeEach
    void setUp() {
        ui = new Ui();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPrintGreeting() {
        ui.printGreeting();

        assertTrue(outContent.toString().contains("Hello! I'm Baymax, your personal emotional companion :)"));
        assertTrue(outContent.toString().contains("How may I help you today?"));
    }

    @Test
    void testPrintExit() {
        ui.printExit();

        assertTrue(outContent.toString().contains("Goodbye. Have a nice day, and remember:"));
        assertTrue(outContent.toString().contains("don't forget to smell the flowers, as you aim for the sky"));
    }

    @Test
    void testPrintError() {
        ui.printError("This is an error!");
        assertTrue(outContent.toString().contains("This is an error!"));
    }

    @Test
    void testReadCommand() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("hello\n".getBytes());
        System.setIn(inContent);

        Ui testUi = new Ui();
        assertEquals("hello", testUi.readCommand());
    }

    @Test
    void testPrintNewTodo() {
        Todo mockTodo = new Todo("New Todo");
        ui.printNewTodo(mockTodo);
        assertTrue(outContent.toString().contains("added: [T][ ] New Todo"));
    }

    @Test
    void testPrintMarkAsDone() {
        Task mockTask = new Todo("Complete Homework");
        ui.printMarkAsDone(mockTask);
        assertTrue(outContent.toString().contains("Good job on completing the task!"));
    }

    @Test
    void testPrintDeleteTask() {
        ui.printDeleteTask(3);
        assertTrue(outContent.toString().contains("delete 3"));
    }
}
