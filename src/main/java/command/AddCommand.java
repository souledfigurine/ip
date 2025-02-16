package command;

public abstract class AddCommand extends Command {
    String name;
    public AddCommand(String name) {
        this.name = name;
    }
}
