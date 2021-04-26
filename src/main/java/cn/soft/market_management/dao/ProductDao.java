package cn.soft.market_management.dao;

import cn.soft.market_management.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {
    int getRowCount(@Param("pname")String pname);

    int saveProduct(Product Product);
    List<Product> findPageObjects(@Param("pname")String pname,
                                   @Param("startIndex")Integer startIndex,
                                   @Param("pageSize")Integer pageSize);
    int deleteObjects(@Param("ids") Integer... ids);

}
