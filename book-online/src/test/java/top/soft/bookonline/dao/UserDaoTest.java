package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

class UserDaoTest {
    @Test
    void insertUser() {
        UserDao userdao = new UserDaoImpl();
        User user = User.builder()
                .account("l")
                .nickname("l").password("1").address("江苏南京").avatar("https://img.zcool.cn/community/031f8gbnpgb8kw5crterdrj3531.png").build();
        userdao.insertUser(user);
    }
}
//https://img.zcool.cn/community/031f8gbnpgb8kw5crterdrj3531.png
// https://tse2-mm.cn.bing.net/th/id/OIP-C.D6OPjljcbEleSA7pz9KM1AAAAA?rs=1&pid=ImgDetMain