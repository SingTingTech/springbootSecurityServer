package com.dipont.security.server.dao;

import com.dipont.security.server.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author alex
 * @date 2019/8/20  10:13
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public SysUser getUserByName(String name){
        RowMapper<SysUser> rowMapper = new BeanPropertyRowMapper<>(SysUser.class);
        List<SysUser> user = jdbcTemplate.query("select * from user where user_name = ?",rowMapper,name);
        if(CollectionUtils.isEmpty(user)){
            return null;
        }else{
            return user.get(0);
        }
    }

    public void saveUser(SysUser user) {
        user.encryptPassword();
        jdbcTemplate.update("insert into user(user_name, password) VALUE (?,?)",user.getUserName(),user.getPassword());
    }
}
