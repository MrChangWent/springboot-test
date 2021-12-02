package com.zhang.testing;

public class test {
    public static void main(String[] args) {
        String table_info_sql = "select bji.`name` as table_name,bji.info as table_info, " +
                "bsi.`name` as db_name from  base_junior_info bji " +
                "left join base_superior_info bsi on bji.superior_id = bsi.id " +
                "where bsi.`category`='hive'";
        System.out.println(table_info_sql);
    }
}
