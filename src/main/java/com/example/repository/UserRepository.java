package com.example.repository;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * Userテーブルを操作するリポジトリです.
 *
 * @author haruka.yamaneki
 */

@Repository
public class UserRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /*
     create table users (
     id serial primary key
     , name varchar(100) not null
     , email varchar(100) not null unique
     , password text not null
     , zipcode varchar(8) not null
     , prefecture varchar(10) not null
     , municipalities varchar(10) not null
     , address varchar(20) not null
     , telephone varchar(15) not null
    ) ;
     */


    /**
     * ユーザー登録を行います.
     *
     * @param user ユーザー情報
     */
    public void insert(User user) {
        String sql = "INSERT INTO users(name,email,password,zipcode,prefecture,municipalities,address,telephone)values(:name,:email,:password,:zipcode,:prefecture,:municipalities,:address,:telephone);";
        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        template.update(sql, param);
    }


}
