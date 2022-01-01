package com.yx.oa.dao;

import com.yx.oa.entity.Department;

public interface DepartmentDao {
    public Department selectById(Long departmenId);
}
