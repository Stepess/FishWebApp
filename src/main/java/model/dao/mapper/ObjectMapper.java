package model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet resultSet) throws SQLException;
    T makeUnique(T obj);
}
