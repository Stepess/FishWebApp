import model.dao.DaoFactory;
import model.dao.UserDao;
import model.dao.jdbc.JdbcDaoFactory;

public class App {
    public static void main(String[] args) {
        DaoFactory daoFactory = new JdbcDaoFactory();
        UserDao userDao = daoFactory.createUserDao();

        System.out.println(userDao.getAll());
    }
}
