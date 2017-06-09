package org.example;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRowMapper implements RowMapper<Result> {

    @Override
    public Result mapRow(ResultSet resultSet, int i) throws SQLException {
        Result result = new Result();
        //result.setId(resultSet.getInt("id"));
        result.setName(resultSet.getString("article_name"));
        result.setOfficialTextCount(resultSet.getInt("count_official_text"));
        result.setEnglishTextCount(resultSet.getInt("count_english_text"));
        return result;
    }

}
