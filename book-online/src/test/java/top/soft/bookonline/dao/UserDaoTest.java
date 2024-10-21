package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void insertUser(){
        UserDao userdao = new UserDaoImpl();
        User user= User.builder()
                .account("dhl")
                .nickname("dhl").password("123456").address("江苏南京").avatar("m.png").build();
        userdao.insertUser(user);
    }

}