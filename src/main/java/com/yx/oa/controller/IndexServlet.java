package com.yx.oa.controller;

import com.yx.oa.dao.EmployeeDao;
import com.yx.oa.entity.Department;
import com.yx.oa.entity.Employee;
import com.yx.oa.entity.Node;
import com.yx.oa.entity.User;
import com.yx.oa.service.DepartmentService;
import com.yx.oa.service.EmployeeService;
import com.yx.oa.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private UserService userService = new UserService();
    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("login_user");
        Employee employee = employeeService.selectById(user.getEmployeeId());
        Department department = departmentService.selectById(employee.getDepartmentId());
        List<Node> nodeList = userService.selectNodeByUserId(user.getUserId());
        req.setAttribute("node_list",nodeList);
        session.setAttribute("current_employee",employee);
        session.setAttribute("current_department",department);
        req.getRequestDispatcher("/index.ftl").forward(req,resp);
    }
}
