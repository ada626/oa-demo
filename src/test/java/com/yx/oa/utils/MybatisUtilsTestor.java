package com.yx.oa.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtilsTestor {
    @Test
    public void test1() {
        String reslut = (String) MybatisUtils.executeQuery(sqlSession->{
            String out =  (String) sqlSession.selectOne("test.sample");
            return out;
        });
        System.out.println(reslut);
    }
    @Test
    public void test2() throws IOException {
        String reslut = (String) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
    }
}
