package cn.soft.market_management.dao;


import cn.soft.market_management.entity.Depot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepotDao {

    int saveDepot(Depot depot);
    int getRowCount(@Param("pname")String pname);
    List<Depot> findPageObjects(@Param("pname")String pname,
                                @Param("startIndex")Integer startIndex,
                                @Param("pageSize")Integer pageSize);
    int deleteObjects(@Param("ids") Integer... ids);
    public List<Depot> selectAll();
}
