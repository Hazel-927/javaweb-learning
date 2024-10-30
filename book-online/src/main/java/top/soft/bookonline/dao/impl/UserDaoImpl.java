package top.soft.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.util.JdbcUtil;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/19 16:43
 */

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user(account,password,nickname,avatar) values(?,?,?,?)";
        return jdbcTemplate.update(sql, user.getAccount(), user.getPassword(), user.getNickname(), user.getAvatar());
    }

    @Override
    public User findUser(User user) {
        try {
            String sql = "select * from t_user where account=? and password=?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getAccount(), user.getPassword());
        } catch (DataAccessException E) {
            E.printStackTrace();
            return null;
        }
    }
}
