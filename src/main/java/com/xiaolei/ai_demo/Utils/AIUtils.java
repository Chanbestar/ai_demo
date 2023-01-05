package com.xiaolei.ai_demo.Utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AIUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "29377477";
    public static final String API_KEY = "yfUgDd8FpFORfNfei0ZSgA1k";
    public static final String SECRET_KEY = "iLUl2AEcs3Q01FE9nGt79Co5GywCC7yG";

    //设置APPID/AK/SK
    public static final String APP_ID_IMG = "29399680";
    public static final String API_KEY_IMG = "ZIBhmrd0nYq0G83wVygocbNG";
    public static final String SECRET_KEY_IMG = "3DYuwLZyPfqKY7GWn9B7hmRoYeEtYC5E";

    //设置APPID/AK/SK
    public static final String APP_ID_TEXT = "29503767";
    public static final String API_KEY_TEXT = "cG3QGQbM84Lxy5bvfUASF8Cj";
    public static final String SECRET_KEY_TEXT = "CowmdCsBzfbumrOaiOlygCBvGRCWSSCl";

    public static String picToWords(MultipartFile file) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        String path = "E:\\code\\pic\\1.PNG";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray words_result = res.getJSONArray("words_result");
        String results = "";
        for (int i = 0; i < words_result.length(); i++) {
            JSONObject jsonObject = words_result.getJSONObject(i);
            Object words = jsonObject.get("words");
            String s = (String) words;
            results += s + "\n";
        }
        System.out.println(results);
        return results;
    }

    public static String picIdentify(MultipartFile file) throws IOException {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID_IMG, API_KEY_IMG, SECRET_KEY_IMG);

        // 调用接口
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        return res.toString(2);

    }

    public static String textCorrect(String text)  {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
         /*
            文本纠错
          */
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 文本纠错
        JSONObject res = client.ecnet(text, options);
        return res.toString(2);
    }
}
