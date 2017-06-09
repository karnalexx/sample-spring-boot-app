package org.example;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeRowMapper implements RowMapper<Type> {

    @Override
    public Type mapRow(ResultSet resultSet, int i) throws SQLException {
        Type type = new Type();
        type.setId(resultSet.getInt("id"));
        type.setName(resultSet.getString("name"));
        return type;
    }

}
