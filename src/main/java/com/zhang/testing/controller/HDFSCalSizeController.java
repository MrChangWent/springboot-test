package com.zhang.testing.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhang.testing.service.SizeCal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class HDFSCalSizeController {


    @Autowired
    private SizeCal sizeCal;

    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "idid:" + id;
    }

    @RequestMapping(value = {"/hdfscal"}, method = RequestMethod.GET)
    public JSONObject returnName(@RequestParam(value = "hdfspath", required = false, defaultValue = "/hbase") String hdfspath) throws IOException, URISyntaxException, InterruptedException {
    }

}