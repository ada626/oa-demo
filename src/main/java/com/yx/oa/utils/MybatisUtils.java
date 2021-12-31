package com.yx.oa.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtils {
    //利用static属于类不属于对象的特点，造出一个全局唯一的SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory = null;
    //利用静态块儿在初始化类时加载的特点，实例化sqlSessionFactory
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            //初始化错误时，抛出ExceptionInInitializerError异常通知调用者
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Object executeQuery(Function<SqlSession,Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Object o = func.apply(sqlSession);
            sqlSession.commit();
            return o;
        }catch (RuntimeException e){
            sqlSession.rollback();
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
    public static SqlSession openSession(){
        //默认SqlSession自动提交事务数据(commit)
        //设置为false才能改为手动提交
        return sqlSessionFactory.openSession(false);
    }
    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}
