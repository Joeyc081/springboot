package cn.soft.market_management.Controller;


import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.entity.ImageVO;
import cn.soft.market_management.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("image")
public class ImgController {

    @Autowired
    ImgService imgService;
    @RequestMapping("/imgFile")
    public JsonResult file(MultipartFile file, HttpServletRequest request,String name,String url,String clas,String sellprice) throws IOException {
        //调用业务层
        System.out.println(file);
        ImageVO img = imgService.upload(file,request,name,url,clas,sellprice);
        return new JsonResult(img);
    }
}