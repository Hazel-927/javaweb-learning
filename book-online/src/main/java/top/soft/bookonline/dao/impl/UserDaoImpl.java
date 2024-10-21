package top.soft.bookonline.dao.impl;

import top.soft.bookonline.util.JdbcUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.util.Md5Util;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/19 16:43
 */

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public int insertUser(User user) {
        String sql ="insert into t_user(account,password,nickname,avatar) values(?,?,?,?)";
        return jdbcTemplate.update(sql,user.getAccount(), Md5Util.crypt(user.getPassword()),user.getNickname(),user.getAvatar());
    }
}
