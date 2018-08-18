package controller.command;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command getCommandFromRequest(HttpServletRequest req) {
        Command command = new DefaultCommand();

        String commandName = req.getParameter("command");
        System.out.println("Command name: " + commandName);
        if (commandName == null || commandName.isEmpty()) {//TODO figure out why is empty
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(commandName.toUpperCase());
            command = commandEnum.getCommand();
        }
        catch (IllegalArgumentException ex) {
            req.setAttribute("wrongAction", commandName);
                    //+ MessageManager.getProperty("message.wrongaction"));
        }
        return command;
    }
}
