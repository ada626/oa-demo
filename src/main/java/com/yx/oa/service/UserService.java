package com.yx.oa.service;

import com.yx.oa.dao.RbacDao;
import com.yx.oa.dao.UserDao;
import com.yx.oa.entity.Node;
import com.yx.oa.entity.User;
import com.yx.oa.service.exception.BussinessException;

import java.util.List;


public class UserService {
    private UserDao userDao = new UserDao();
    private RbacDao rbacDao = new RbacDao();
    /**
     * 根据前台输入进行登录校验
     * @param username 前台输入的用户名
     * @param password 前台输入的密码
     * @return 校验通过后，包含对应用户数据的User实体类
     * @throws BussinessException L001-用户名不存在，L002-密码错误
     */
    public User checkLogin(String username, String password){
        User user = userDao.selectByUsername(username);
        if(user==null){
            throw new BussinessException("L001","username not found");
        }
        if(!password.equals(user.getPassword())){
            throw new BussinessException("L002","wrong password");
        }
        return user;
    }
    public List<Node> selectNodeByUserId(Long userId){
        List<Node> nodeList = rbacDao.selectNodeByUserId(userId);
        return nodeList;
    }
}
