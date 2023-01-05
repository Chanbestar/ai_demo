package com.xiaolei.ai_demo.Controller;

import com.xiaolei.ai_demo.Utils.AIUtils;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;
/**
 * 文件上传配置
 *
 * @return
 */
@CrossOrigin
@RestController
public class AIController {
    @RequestMapping(value = "/pic" , method = RequestMethod.POST)
    public String PicToWord(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AIUtils.picToWords(file);
        return res;
    }

    @RequestMapping(value = "/img" , method = RequestMethod.POST)
    public String PicToIMG(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AIUtils.picIdentify(file);
        return res;
    }
    @RequestMapping(value = "/correction" , method = RequestMethod.GET)
    public String TextCorr(@RequestParam("text") String text)  {
        System.out.println(text);
        String res = AIUtils.textCorrect(text);
        return res;
    }
}


