package cn.soft.market_management.dao;

import cn.soft.market_management.entity.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProviderDao {
    int getRowCount(@Param("proname")String proname);

    int saveProvider(Provider provider);
    List<Provider> findPageObjects(@Param("proname")String proname,
                                   @Param("startIndex")Integer startIndex,
                                   @Param("pageSize")Integer pageSize);
    int deleteObjects(@Param("ids") Integer... ids);




}
