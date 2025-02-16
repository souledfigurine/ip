package command;

import baymax.TaskList;
import baymax.Storage;
import baymax.Ui;

public abstract class Command {
    private Boolean exit = Boolean.FALSE;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return this.exit;
    }
    protected void makeExit() {
        this.exit = Boolean.TRUE;
    }
}
