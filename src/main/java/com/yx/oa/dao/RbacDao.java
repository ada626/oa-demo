package com.yx.oa.dao;

import com.yx.oa.entity.Node;
import com.yx.oa.utils.MybatisUtils;

import java.util.List;

public class RbacDao {
    public List<Node> selectNodeByUserId(Long userId){
        return (List)MybatisUtils.executeQuery(sqlSession->sqlSession.selectOne("rbacmapper.selecNodeByUserId"));
    }
}
