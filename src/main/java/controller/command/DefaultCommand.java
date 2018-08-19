package controller.command;

import controller.Utils.SessionRequestContent;
import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;

public class DefaultCommand implements Command {

    //TODO guess how to delete
    @Override
    public String execute(SessionRequestContent content) {
        ResourceManager manager = new PagePathManager();
        return manager.getProperty("path.page.index");
    }
}
