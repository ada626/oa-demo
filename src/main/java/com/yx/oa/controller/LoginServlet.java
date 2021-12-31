package com.yx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.yx.oa.entity.User;
import com.yx.oa.service.UserService;
import com.yx.oa.service.exception.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="LoginServlet",urlPatterns = "/check_login")
public class LoginServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        //接收前台数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String,Object> result  = new HashMap<>();
        try {
            //调用业务逻辑
            User user = userService.checkLogin(username,password);
            HttpSession session = req.getSession();
            session.setAttribute("login_user",user);
            result.put("code","0");
            result.put("message","success");
            result.put("redirect_url","/index");
        }catch (BussinessException e){
            logger.error(e.getMessage(),e);
            result.put("code",e.getCode());
            result.put("message",e.getMessage());
        }
        catch (Exception e) {
            logger.error(e.getMessage(),e);
            result.put("code",e.getClass().getSimpleName());
            result.put("message",e.getMessage());
        }
        //返回处理结果
        String json = JSON.toJSONString(result);
        resp.getWriter().println(json);
    }
}
