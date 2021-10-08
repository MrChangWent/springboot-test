package com.zhang.testing.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhang.testing.bean.MysqlBean;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class QueryMysqlController {

    private Logger logger = Logger.getLogger(String.valueOf(QueryMysqlController.class));

    @RequestMapping(value = "/q1", method = RequestMethod.POST)
    public JSONObject query(@RequestBody JSONObject queryInfo) throws SQLException, JSONException {

        JSONObject queryRes = new JSONObject();
        String querySql = queryInfo.getString("sql");
        MysqlBean mysqlBean = new MysqlBean();
        Connection connection = mysqlBean.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(querySql);
        int datacount = 0;

        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1));
            logger.info(resultSet.getString(1));
            queryRes.put(String.valueOf(datacount),resultSet.getString(1));
            datacount += 1;
        }
        connection.close();
        return queryRes;
    }

    @RequestMapping(value = "/q2", method = RequestMethod.POST)
    public String query2(@RequestBody JSONObject queryinfo) {
        String name = queryinfo.getString("id");
        return name;
    }
}
