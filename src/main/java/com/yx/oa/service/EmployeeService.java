package com.yx.oa.service;

import com.yx.oa.dao.EmployeeDao;
import com.yx.oa.entity.Employee;
import com.yx.oa.utils.MybatisUtils;

public class EmployeeService {
    public Employee selectById(Long employeeId){
        //getMapper方法可以自动生成对应接口的实现类
        //生成规则依照xml的配置
        return (Employee) MybatisUtils.executeQuery(sqlSession->{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            return employeeDao.selectById(employeeId);
        });
    }
}
