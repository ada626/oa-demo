package com.yx.oa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
        //要是使用其他数据池管理，只需要实例化不同的datasource即可
    }

    @Override
    //DataSource接口是行业的标准，每个数据池都要按这个标准实现对应的实现类
    public DataSource getDataSource() {
        try {
            //init方法是强制执行的，要检查各种启动项是否正确
            ((DruidDataSource) this.dataSource).init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.dataSource;
    }
}
