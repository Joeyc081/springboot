package cn.soft.market_management.dao;

import cn.soft.market_management.entity.Sell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SellDao {
    int saveSell(Sell sell);
    int getRowCount(@Param("pname")String pname);
    List<Sell> findPageObjects(@Param("pname")String pname,
                               @Param("startIndex")Integer startIndex,
                               @Param("pageSize")Integer pageSize);
    int deleteObjects(@Param("ids") Integer... ids);

}
