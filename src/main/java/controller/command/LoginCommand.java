package controller.command;

import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;
import model.service.LoginService;

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

        LoginService loginService = new LoginService();

        if (loginService.authorization(login, password)) {
            loginService.setUserInSession(req.getSession(), login, loginService.getUserRole(login));
            //System.out.println(req.getSession().getAttribute("role"));
            return "redirect:" +  loginService.getUserRole(login).toString().toLowerCase()
                    + manager.getProperty("path.page.main");
        }

        return manager.getProperty("path.page.index");
    }
}
