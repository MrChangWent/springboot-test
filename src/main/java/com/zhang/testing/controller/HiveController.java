package com.zhang.testing.controller;

import com.zhang.testing.service.HiveJDBCTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HiveController {

    public final static Logger logger = LoggerFactory.getLogger(HiveController.class);

    @Autowired
    private HiveJDBCTest hiveJDBCTest;


    @GetMapping(value = "/sql")
    public List<String> say(@RequestParam(value = "limitNum", required = false, defaultValue = "0") Integer limitNum)
            throws SQLException {

        List<String> res =  hiveJDBCTest.execSql(limitNum);
        return  res;

    }
}