package com.zhang.testing.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import com.alibaba.fastjson.JSON;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;


public class SizeCal {

    public JSONObject SizeRes(String HDFSAbsPath) throws IOException {
       Configuration hadoopconf = new Configuration();
       FileSystem hdfs = FileSystem.get(hadoopconf);
       Path dfs = new Path(HDFSAbsPath);
       hdfs.getFileStatus(dfs);
       return null;
    }

}
