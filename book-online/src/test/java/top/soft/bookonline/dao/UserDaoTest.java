package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

class UserDaoTest {
    @Test
    void insertUser() {
        UserDao userdao = new UserDaoImpl();
        User user = User.builder()
                .account("dhl")
                .nickname("dhl").password("123456").address("江苏南京").avatar("https://img.zcool.cn/community/031f8gbnpgb8kw5crterdrj3531.png").build();
        userdao.insertUser(user);
    }
}