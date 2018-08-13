package service.command;

import service.resource.manager.PagePathManager;
import service.resource.manager.ResourceManager;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command{
    @Override
    public String execute(HttpServletRequest req) {
        ResourceManager manager = new PagePathManager();
        return manager.getProperty("path.page.index");
    }
}
