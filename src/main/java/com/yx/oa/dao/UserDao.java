package com.yx.oa.dao;

import com.yx.oa.entity.User;
import com.yx.oa.utils.MybatisUtils;

//对刚刚配置的user.xml中的selectedByUsername进行调用
public class UserDao {
    public User selectByUsername(String username){
        User user= (User)MybatisUtils.executeQuery(sqlSession->sqlSession.selectOne("usermapper.selectByUsername",username));
        return user;
    }
}
