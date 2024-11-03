package top.soft.bookonline.service.impl;

import top.soft.bookonline.dao.RegisterDao;
import top.soft.bookonline.dao.impl.RegisterDaoImpl;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.RegisterService;

import javax.sql.DataSource;

public class RegisterServiceImpl implements RegisterService {
    private final DataSource dataSource;
    private final RegisterDao registerDao;

    public RegisterServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.registerDao = new RegisterDaoImpl(dataSource);
    }

    @Override
    public User register(User user) {
        String account = user.getAccount();
        // 假设密码已经在外部加密好传入
        String password = user.getPassword();
        // 检查用户是否已存在
        User existingUser = registerDao.findUserByAccount(account);
        if (existingUser != null) {
            return null; // 用户已存在
        }
        // 插入新用户
        user.setPassword(password);
        boolean inserted = registerDao.insertUser(user);
        if (inserted) {
            return user;
        }
        return null; // 注册失败
    }
}