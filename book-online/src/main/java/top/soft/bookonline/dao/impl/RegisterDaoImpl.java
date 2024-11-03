package top.soft.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.RegisterDao;
import top.soft.bookonline.entity.User;

import javax.sql.DataSource;

public class RegisterDaoImpl implements RegisterDao {
    private final JdbcTemplate jdbcTemplate;

    public RegisterDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insertUser(User user) {
        String sql = "INSERT INTO t_user (account, password) VALUES (?,?)";
        try {
            int rowsAffected = jdbcTemplate.update(sql, user.getAccount(), user.getPassword());
            return rowsAffected > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findUserByAccount(String account) {
        String sql = "SELECT * FROM t_user WHERE account =?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), account);
        } catch (DataAccessException e) {
            // 如果没有找到用户，返回null
            return null;
        }
    }
}