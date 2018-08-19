package controller.command;

import controller.Utils.SessionRequestContent;

public interface Command {
    String execute(SessionRequestContent content);
}
