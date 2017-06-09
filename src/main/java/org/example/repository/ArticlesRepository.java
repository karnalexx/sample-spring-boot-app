package org.example.repository;

import org.example.Result;
import org.example.ResultRowMapper;
import org.example.Type;
import org.example.TypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ArticlesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Type> findAllTypes() {
        return jdbcTemplate.query("select * from types", new TypeRowMapper());
    }

    @Transactional(readOnly = true)
    public List<Result> findArticlesAndRelatedTextCountByType(int typeId) {
        return jdbcTemplate.query(
                "select a.name as article_name, count(al.*) as count_official_text, count(al1.*) as count_english_text" +
                        " from articles a" +
                        " left join article_link al on a.id = al.article1_id and al.article2_id in (select a.id from articles a where a.type_id = 4)" +
                        " left join article_link al1 on a.id = al1.article1_id and al1.article2_id in (select a.id from articles a where a.type_id = 5)" +
                        " group by a.type_id, a.name having a.type_id = ? order by a.name",
                new Object[]{typeId}, new ResultRowMapper());
    }

}
