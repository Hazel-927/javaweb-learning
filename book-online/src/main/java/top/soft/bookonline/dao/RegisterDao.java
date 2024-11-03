package top.soft.bookonline.dao;

import top.soft.bookonline.entity.User;

public interface RegisterDao {
    // 插入用户数据的方法
    boolean insertUser(User user);

    // 根据账号查找用户的方法（可用于检查账号是否已存在）
    User findUserByAccount(String account);
}