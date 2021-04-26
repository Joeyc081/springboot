package cn.soft.market_management.dao;


import cn.soft.market_management.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysLogDao {
    int getRowCount(@Param("username")String username);

    List<SysLog>findPageObjects(@Param("username")String username,
                                @Param("startIndex")Integer startIndex,
                                @Param("pageSize")Integer pageSize);

    int deleteObjects(@Param("ids") Integer... ids);
    //插入日志
    int insertObject(SysLog sysLog);

}

