package model.dao.jdbc;

import model.dao.UserDao;
import model.entity.User;

import javax.sql.DataSource;
import java.util.List;

public class JdbcUserDao implements UserDao {
    private DataSource source;

    public JdbcUserDao(DataSource source) {
        this.source = source;
    }

    @Override
    public boolean setInDb(User entity) {
        return false;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
