package com.xiaolei.ai_demo.test;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.HashMap;

public class NLP {
        //设置APPID/AK/SK
        public static final String APP_ID = "29503767";
        public static final String API_KEY = "cG3QGQbM84Lxy5bvfUASF8Cj";
        public static final String SECRET_KEY = "CowmdCsBzfbumrOaiOlygCBvGRCWSSCl";

        public static void main(String[] args) {
            // 初始化一个AipNlp
            AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

            // 调用接口
            String text = "百度是一家高科技公司";
            JSONObject res = client.lexer(text, null);
            System.out.println(res.toString(2));

            String text1 = "垃圾";

            // 传入可选参数调用接口
            HashMap<String, Object> options = new HashMap<String, Object>();

            // 情感倾向分析
            JSONObject res1 = client.sentimentClassify(text1, options);
            System.out.println(res1.toString(2));

            /*
            文本纠错
             */
            String text2 = "在腾讯总部深帧";

            // 传入可选参数调用接口
            HashMap<String, Object> options2 = new HashMap<String, Object>();

            // 文本纠错
            JSONObject res2 = client.ecnet(text2, options2);
            System.out.println(res2.toString(2));
        }
}
