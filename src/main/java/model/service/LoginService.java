package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.RoleEnum;

import javax.servlet.http.HttpSession;

public class LoginService {
    private UserDao userDao;

    public LoginService() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.createUserDao();
    }

    public boolean authorization(String login, String password) {
        return userDao.isUserExist(login, password);
    }

    public void setUserInSession(HttpSession session, String login, RoleEnum role) {
        session.setAttribute("role", role);
        session.setAttribute("login", login);
    }

    public RoleEnum getUserRole(String login) {
        return userDao.getByLogin(login).getRole();
    }
}
