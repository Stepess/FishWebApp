package service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;

import java.util.List;

//TODO which layer is must contain it?
public class LoginLogic {
    public boolean authorization (String login, String password) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();

        List<User> users = userDao.getAll();

        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }
}
