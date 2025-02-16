package command;

public class ErrorCommand extends Command {
    private final String errorMessage;
    public ErrorCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @Override
    public void execute() {

    }
}
