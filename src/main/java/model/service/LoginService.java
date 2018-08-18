package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.RoleEnum;

import javax.servlet.http.HttpSession;

public class LoginService {
    public boolean authorization(String login, String password) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        return userDao.isUserExist(login, password);
    }

    public void setUserInSession(HttpSession session, String login, RoleEnum role) {
        System.out.println(role);
        session.setAttribute("role", role);
        session.setAttribute("login", login);
    }

    public RoleEnum getUserRole(String login) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        return userDao.getByLogin(login).getRole();
    }
}
