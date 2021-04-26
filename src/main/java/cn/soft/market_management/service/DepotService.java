package cn.soft.market_management.service;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Depot;

import java.util.List;


public interface DepotService {
    int saveDepot(Depot depot);
    PageObject<Depot> findPageObjects(String pname, Integer pageCurrent) throws IllegalAccessException;
    int deleteObjects(Integer...ids) throws IllegalAccessException;
    public List<Depot> selectAll();
}
