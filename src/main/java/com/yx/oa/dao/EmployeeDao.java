package com.yx.oa.dao;
import com.yx.oa.entity.Employee;

public interface EmployeeDao {
    public Employee selectById(Long employeeId);
    public Employee selectLeader(Employee employee);
}
