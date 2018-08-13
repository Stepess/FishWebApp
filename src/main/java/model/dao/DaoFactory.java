package model.dao;

import model.dao.jdbc.JdbcDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JdbcDaoFactory();
                }
            }
        }
        return daoFactory;
    }

}
