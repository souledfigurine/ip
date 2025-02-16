package command;

public class AddDeadlineCommand extends AddCommand{
    String by;
    public AddDeadlineCommand(String name, String by) {
        super(name);
        this.by = by;
    }
    @Override
    public void execute() {

    }
}
