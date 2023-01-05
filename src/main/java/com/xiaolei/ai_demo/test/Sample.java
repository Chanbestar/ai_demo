package com.xiaolei.ai_demo.test;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "29399680";
    public static final String API_KEY = "ZIBhmrd0nYq0G83wVygocbNG";
    public static final String SECRET_KEY = "3DYuwLZyPfqKY7GWn9B7hmRoYeEtYC5E";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        String path = "E:\\code\\pic\\2.jpg";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}

