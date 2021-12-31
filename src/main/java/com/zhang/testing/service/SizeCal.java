package com.zhang.testing.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SizeCal {


    public static FileSystem HDFS(String HDFSAbsPath) throws URISyntaxException, IOException, InterruptedException {

        Configuration hadoopconf = new Configuration();
        hadoopconf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        FileSystem hdfs = FileSystem.get(new URI("hdfs://hadoop2:8020"), hadoopconf, "hdfs");
        return hdfs;
    }

    public JSONObject CalFloderSize(String HDFSPath) throws IOException, URISyntaxException, InterruptedException {

        FileSystem hdfs = HDFS(HDFSPath);
        Path dfs = new Path(HDFSPath);
        long res = hdfs.getUsed(dfs);
        JSONObject jsonres = new JSONObject();
        jsonres.put(HDFSPath, res);

        return jsonres;
    }


    public List<String> GetSubFolder(String HDFSPath) throws URISyntaxException, IOException, InterruptedException {

        List<String> subFolderList = new ArrayList();
        FileSystem hdfs = HDFS(HDFSPath);
        Path dfs = new Path(HDFSPath);
        FileStatus[] res = hdfs.listStatus(dfs);
        for (FileStatus fileStatus : res) {
            subFolderList.add(fileStatus.getPath().toString());
        }

        return subFolderList;
    }

    public JSONObject RecurtionGetFolderSize(String HDFSPath, int count) throws URISyntaxException, IOException, InterruptedException {

        if (count == 3){
            SizeCal sizeCal = new SizeCal();
            JSONObject floderSize = sizeCal.CalFloderSize(HDFSPath);
            return  floderSize;
        } else {

            List subfolder = GetSubFolder(HDFSPath);
            for (int i = 0; i < subfolder.toArray().length; i++) {

                return null;
            }
        }
        return null;
    }

}