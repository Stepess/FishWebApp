package controller.command;

import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        ResourceManager manager = new PagePathManager();
        if (request.getSession()!= null)
            request.getSession().invalidate();
        return "redirect:" + manager.getProperty("path.page.index");
    }
}
