package com.yx.oa.controller;

import com.yx.oa.entity.Node;
import com.yx.oa.entity.User;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("login_user");
        List<Node> nodeList = userService.selectNodeByUserId(user.getUserId());
        req.setAttribute("node_list",nodeList);
        req.getRequestDispatcher("/index.ftl").forward(req,resp);
    }
}
