package cn.soft.market_management.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {


    private static final long serialVersionUID = 8908580177531548529L;

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid;
    private Integer deptId;
    private Date createTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;




}
