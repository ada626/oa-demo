package com.yx.oa.service;

import com.yx.oa.dao.DepartmentDao;
import com.yx.oa.entity.Department;
import com.yx.oa.utils.MybatisUtils;

public class DepartmentService {
    public Department selectById(Long departmentId){
        return (Department) MybatisUtils.executeQuery(sqlSession->sqlSession.getMapper(DepartmentDao.class).selectById(departmentId));
    }
}
