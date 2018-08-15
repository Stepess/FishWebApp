package controller.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }

}
