package controller.command;

import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;
import model.service.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ResourceManager manager = new PagePathManager();

        String login = request.getParameter("login");
        String password =  request.getParameter("password");

        if (login == null || password == null){
            return manager.getProperty("path.page.index");
        }

        LoginService loginService = new LoginService();

        if (loginService.checkLoginPassword(login, password)) {
            loginService.setUserInSession(request.getSession(), login, loginService.getUserRole(login));
            return "redirect:/" +  loginService.getUserRole(login).toString().toLowerCase()
                    + manager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", "Wrong login password");
        }

        return manager.getProperty("path.page.index");
    }
}
