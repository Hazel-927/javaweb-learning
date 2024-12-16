package top.soft.classoa.mapper;

import org.junit.jupiter.api.Test;
import top.soft.classoa.entity.Employee;
import top.soft.classoa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeeMapperTest {

    @Test
    void selectByParams() {
        MybatisUtils.executeQuery(sqlSession -> {
            Map<String, Object> params = new HashMap<>();
            params.put("departmentId", 2);
            params.put("level", 7);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> leaders = employeeMapper.selectByParams(params);
            System.out.println(leaders.get(0));
            return leaders.get(0);
        });
    }
}