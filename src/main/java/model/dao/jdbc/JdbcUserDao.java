package model.dao.jdbc;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.User;
import service.resource.manager.DataBaseManager;
import service.resource.manager.ResourceManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao {
    private DataSource source;
    private ResourceManager manager;

    public JdbcUserDao(DataSource source) {
        this.source = source;
        this.manager = new DataBaseManager();
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

        List<User> users = new ArrayList<>();
        UserMapper userMapper = new UserMapper();

        try (
                Connection connection = source.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(manager.getProperty("db.user.query.all"))
        ) {
            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
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
