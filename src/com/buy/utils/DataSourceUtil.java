package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.resource.spi.Connector;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class DataSourceUtil {
    private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
    private static String url = "jdbc:mysql://127.0.0.1:3306/easybuy?useUnicode=true&characterEncoding=utf-8";// 连接URL字符串
    private static String user = "root"; // 数据库用户名
    private static String password = "root"; // 用户密码


    /**
     * 配置罗里巴巴数据源
     */
    //创建druid数据源对象
    private static DruidDataSource druidDataSource = null;
    static {
        init();
    }
    public static void init(){
        //实例化DruidDataSource
        druidDataSource = new DruidDataSource();
        //设置属性的值
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        //设置连接池相关属性
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxActive(100);
        druidDataSource.setMinIdle(1);//最大空闲连接数
        druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        try {
            druidDataSource.setFilters("stat");//设置监控
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn(){
        Connection conn = null;
        //加载MySQL驱动（开启服务）
        try {
            Class.forName(driver);
            if (conn == null) {
                conn = druidDataSource.getConnection(user, password);
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static  void  closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
