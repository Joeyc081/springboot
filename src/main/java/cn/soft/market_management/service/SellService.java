package cn.soft.market_management.service;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Sell;


public interface SellService {


    int saveSell(Sell sell);
    PageObject<Sell> findPageObjects(String pname, Integer pageCurrent) throws IllegalAccessException;
    int deleteObjects(Integer...ids) throws IllegalAccessException;


}
