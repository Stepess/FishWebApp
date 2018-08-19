package controller.command;

import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    //TODO guess how to delete
    @Override
    public String execute(HttpServletRequest request) {
        ResourceManager manager = new PagePathManager();
        return manager.getProperty("path.page.index");
    }
}
