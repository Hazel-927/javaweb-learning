package top.soft.classoa.service;

import org.junit.jupiter.api.Test;
import top.soft.classoa.entity.Employee;


class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void selectById() {
        Employee employee = employeeService.selectById(1L);
        System.out.println(employee);
    }


    @Test
    void selectLeader() {
        Employee leader = employeeService.selectLeader(4L);
        System.out.println(leader);
    }
}