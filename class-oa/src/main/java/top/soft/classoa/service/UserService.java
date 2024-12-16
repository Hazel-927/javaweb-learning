package top.soft.classoa.service;


import top.soft.classoa.entity.User;
import top.soft.classoa.mapper.UserMapper;
import top.soft.classoa.utils.Md5Utils;

import javax.security.auth.login.LoginException;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/30 15:06
 */

public class UserService {
    private final UserMapper userMapper = new UserMapper();

    /**
     * 根据前端传的数据，进行登录验证
     *
     * @param username 前端输入的用户名
     * @param password 前端输入的密码
     * @return 登录用户对象
     * @throws LoginException 用户登录异常
     */
    public User login(String username, String password) throws LoginException {
        User user = userMapper.selectByUserName(username);
        if (user == null) {
            throw new LoginException("用户名不存在");
        }

        // 对password进行md5加salt加密，得到密文
        String md5Password = Md5Utils.md5Digest(password, user.getSalt());
        if (!md5Password.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }
}
