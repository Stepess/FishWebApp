package controller.command;

import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest req) {
        System.out.println("hello from logout");
        ResourceManager manager = new PagePathManager();
        if (req.getSession()!= null)
            req.getSession().invalidate();
        return manager.getProperty("path.page.index");
    }
}
