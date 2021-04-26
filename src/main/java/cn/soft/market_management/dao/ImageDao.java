package cn.soft.market_management.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
@Mapper
public interface ImageDao {
    void  upload(MultipartFile uploadFile, HttpServletRequest request,String name,String url,String clas,String sellprice);

}
