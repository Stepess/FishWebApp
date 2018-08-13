package service.command;

import service.resource.manager.PagePathManager;

public class DefaultCommand implements Command{
    private PagePathManager pathManager;

    public DefaultCommand() {
        pathManager = new PagePathManager();
    }

    @Override
    public String execute() {
        return pathManager.getProperty("path.page.index");
    }
}
