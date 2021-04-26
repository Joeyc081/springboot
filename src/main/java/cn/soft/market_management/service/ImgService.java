package cn.soft.market_management.service;

import cn.soft.market_management.entity.ImageVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ImgService {
    public ImageVO upload(MultipartFile uploadFile, HttpServletRequest request,String name,String url,String clas,String sellprice) throws IOException;

}
