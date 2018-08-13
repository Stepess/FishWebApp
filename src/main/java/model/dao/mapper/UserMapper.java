package model.dao.mapper;

import model.entity.RoleEnum;
import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(RoleEnum.valueOf(resultSet.getString("role").toUpperCase()));
        return user;
    }

    @Override
    public User makeUnique(User obj) {
        return null;
    }
}
