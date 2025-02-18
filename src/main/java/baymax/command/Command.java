package baymax.command;

import baymax.TaskList;
import baymax.Storage;
import baymax.Ui;

public abstract class Command {
    protected Boolean exit = Boolean.FALSE;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return this.exit;
    }
    public void setExit() {
        this.exit = true;
    }
}
