package top.soft.classoa.mapper;


import top.soft.classoa.entity.User;
import top.soft.classoa.utils.MybatisUtils;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/30 14:49
 */

public class UserMapper {
    public User selectByUserName(String username) {
        return (User) MybatisUtils.executeQuery(sqlSession ->
                sqlSession.selectOne("top.soft.classoa.mapper.UserMapper.selectByUserName", username));
    }

}
