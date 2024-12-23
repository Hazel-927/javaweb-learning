package top.soft.brandlist.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/9 16:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private String description;
}
