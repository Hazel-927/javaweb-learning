package top.soft.classoa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/12/7 13:35
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Long departmentId;
    private String departmentName;
}