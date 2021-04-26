package cn.soft.market_management.service.Impl;


import cn.soft.market_management.dao.ImageDao;
import cn.soft.market_management.entity.ImageVO;
import cn.soft.market_management.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ImgServiceImpl implements ImgService {

    //本地上传的路径
    private String localDir="C:/imageTest/";
    //访问的虚拟路径
    private String url="http://localhost:8081/imageTest/";
    @Autowired
    ImageDao imageDao;

    public  ImageVO upload(MultipartFile uploadFile, HttpServletRequest request,String name,String img,String clas,String sellprice) {
        //校验图片
        String fileName=uploadFile.getOriginalFilename();
        fileName = fileName.toLowerCase();
        if(!fileName.matches("^.+\\.(jpg|png|gif)$")){
            return ImageVO.fail();
        }

        //保存这张图片
        try {
            BufferedImage bufferedImage= ImageIO.read(uploadFile.getInputStream());
            int width=bufferedImage.getWidth();
            int height=bufferedImage.getHeight();
            if(width==0||height==0){
                return ImageVO.fail();
            }
            //获取当前的日期    2020/09/18
            String datePath=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
            //   图片上传本地的路径             D:/imageTest/2020/09/18
            String fileDir=localDir+datePath;
            File imageFile=new File(fileDir);
            if(!imageFile.exists()){
                imageFile.mkdirs();//创建图片的多级路径
            }
            //动态生成文件的名字
            String uuid= UUID.randomUUID().toString().replace("-","");
            //获取当前图片的后缀
            int index=fileName.lastIndexOf(".");
            String fileType=fileName.substring(index);//文件后缀
            //本地真实图片路径   D:/imageTest/2020/09/18+ ???? +  .png
            String realFilePath=fileDir+uuid+fileType;
            System.out.println("本地上传路径："+realFilePath);
            //指定路径的生成文件
            uploadFile.transferTo(new File(realFilePath));

            //虚拟路径              /2020/09/18+ ???? +  .png
            String realUrl = url+datePath+uuid+fileType;
            return ImageVO.success(realUrl,width,height);
        } catch (IOException e) {
            e.printStackTrace();
            return ImageVO.fail();
        }
    }

}