package top.soft.classoa.service;


import top.soft.classoa.entity.Department;
import top.soft.classoa.mapper.DepartmentMapper;
import top.soft.classoa.utils.MybatisUtils;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/12/7 14:11
 */

public class DepartmentService {
    public Department selectById(Long departmentId) {
        return (Department) MybatisUtils.executeQuery(sqlSession ->
                sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
    }
}
