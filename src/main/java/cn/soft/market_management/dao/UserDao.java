package cn.soft.market_management.dao;

import cn.soft.market_management.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper

public interface UserDao {
    public SysUser findUserByUsername(String username);
    //添加用户
    public int saveUser(SysUser sysUser);
    int getRowCount(@Param("username")String username);

    List<SysUser> findPageObjects(@Param("username")String username,
                                  @Param("startIndex")Integer startIndex,
                                  @Param("pageSize")Integer pageSize);

}
