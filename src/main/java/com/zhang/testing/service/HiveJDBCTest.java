package com.zhang.testing.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HiveJDBCTest implements InitializingBean {
    public final static Logger logger = LoggerFactory.getLogger(HiveJDBCTest.class);


    //驱动，URL，用户名，密码，数据库
    public static final String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    public static final String HIVE_URL = "jdbc:hive2://hadoop1:10000";
    public static final String USER_NAME = "hive";
    public static final String PASSWORD = "hive";

    public List<String> execSql(int limitNum) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null, pstmt1 = null;
        ResultSet rs = null;
        List<String> dataset = new ArrayList<String>();

        try {
            //加载驱动，创建连接
            Class.forName(HIVE_DRIVER);
            conn = DriverManager.getConnection(HIVE_URL, USER_NAME, PASSWORD);

            //使用PreparedStatement,这里注意，查询的时候使用的是executeQuery，而且会有结果集返回其他的加载数据，创表创库等操作用的是execute方法

            String sql = String.format("select name, count(1) as cnt from default.zwt1 group by name limit %d", limitNum);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            logger.info("start get dataset===================================");
            //遍历输出每一行查询结果，注意get方法对应的字段的类型
            while (rs.next() != false) {
                String perdata = rs.getString(1) + " " + rs.getInt(2);
//                System.out.println(rs.getString(1) + " " +
//                        rs.getInt(2));
                dataset.add(perdata);
                logger.info(perdata);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
        return dataset;

    }

    public void afterPropertiesSet() throws Exception {

    }
}