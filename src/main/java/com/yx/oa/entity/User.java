package com.yx.oa.entity;

import lombok.Data;

/**
 * lombok 依赖 + lombok 插件
 * 用注释减少代码
 * @Data = @Setter + @Getter
 * @Setter = 生成字段的set方法
 * @Getter = 生成字段的get方法
 */

@Data
public class User {
    //属性名与字段名一一对应
    private Long userId;
    private String userName;
    private String password;
    private Long employeeId;
}
