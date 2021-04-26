package cn.soft.market_management.service;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Product;

public interface ProductService {
    int saveProduct(Product product);
    PageObject<Product> findPageObjects(String pname, Integer pageCurrent) throws IllegalAccessException;
    int deleteObjects(Integer...ids) throws IllegalAccessException;
}
