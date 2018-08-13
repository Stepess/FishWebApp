package service.command;

import service.LoginLogic;
import service.resource.manager.PagePathManager;
import service.resource.manager.ResourceManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        ResourceManager manager = new PagePathManager();

        String login = req.getParameter("login");
        String password =  req.getParameter("password");

        if (login == null || password == null){
            return manager.getProperty("path.page.index");
        }

        LoginLogic loginLogic = new LoginLogic();

        if (loginLogic.authorization(login, password)) {
            req.setAttribute("login", login);
            return manager.getProperty("path.page.main");
        }

        return manager.getProperty("path.page.index");
    }
}
