package top.soft.classoa.mapper;

import top.soft.classoa.entity.Department;

public interface DepartmentMapper {
    /**
     * 根据部门id查询部门信息
     *
     * @param departmentId 部门id
     * @return 部门信息
     */
    Department selectById(Long departmentId);
}